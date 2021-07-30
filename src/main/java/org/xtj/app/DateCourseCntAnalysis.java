package org.xtj.app;

import com.google.common.util.concurrent.ListenableFuture;
import org.apache.flink.api.common.functions.AggregateFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.AllWindowedStream;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.timestamps.BoundedOutOfOrdernessTimestampExtractor;
import org.apache.flink.streaming.api.functions.windowing.AllWindowFunction;
import org.apache.flink.streaming.api.functions.windowing.ProcessAllWindowFunction;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.util.Collector;
import org.xtj.bean.ChapCount;
import org.xtj.grpc.GRPCClient;
import org.xtj.utils.DateTimeUtil;
import org.xtj.utils.MyKafkaUtil;
import org.xtj.utils.RegexUtil;
import scala.Tuple2;
import usercourse.UserCourse;
import usercourse.usrcouseGrpc;

import java.util.*;


public class DateCourseCntAnalysis {

    private static String topic = "access_log";
    private static String consumerId = "consumer2-03";
    private static GRPCClient grpcClient;
    public static void main(String[] args) throws Exception {
        grpcClient = new GRPCClient();
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        FlinkKafkaConsumer<String> kafkaSource = MyKafkaUtil.getKafkaSource(topic, consumerId);

        SingleOutputStreamOperator<String> accessLogDS = env.addSource(kafkaSource)
                .filter(x -> x.length() > 10 && x.split(" ").length > 2);

//        accessLogDS.print();

        //output: ChapCount(startTime=, endTime=, chapId=13771, courName=判断推理专项提升班, courNameNum=1, ts=1623151364000)
        SingleOutputStreamOperator<ChapCount> courseDS = accessLogDS.map(new RichMapFunction<String, ChapCount>() {

            @Override
            public void open(Configuration parameters) throws Exception {
            }

            @Override
            public ChapCount map(String s) throws Exception {

                ArrayList<Integer> integers = new ArrayList<>();
                //获取课程名
                String[] strings = s.split(" ");
                Integer chpId = RegexUtil.findRegx(strings[1]);
                integers.add(chpId);
                ListenableFuture<UserCourse.GetCourseInfoResponse> courseIds = grpcClient.getCourseIds(integers);
                String courseName = "";
                String chapName = "";
                Integer tcId = 0;
                String tcName = "";
                Integer cateId = 0;
                String  cateName = "";
                String  coursePro = "";
                String courseCity = "";
                String courseArea = "";
                for (UserCourse.GetCourseInfoResponse.Detailed detailed : courseIds.get().getDetailedList()) {
                    courseName = detailed.getCourseName();
                    chapName = detailed.getLessonName();
                    tcId = detailed.getTeacherId();
                    tcName = detailed.getTeacherName();
                    cateId = detailed.getCateId();
                    cateName = detailed.getCateName();
                    coursePro = detailed.getCoursePro();
                    courseCity = detailed.getCourseCity();
                    courseArea = detailed.getCourseArea();
                }
                //获取时间
                String dateStr = DateTimeUtil.toYMDhms(strings[0].split("\\|")[0]);
                Long ts = DateTimeUtil.toTS(dateStr);
                //获取播放时间
                Float pyTime = RegexUtil.findPlaytime(strings[1]);

                return new ChapCount("", "",courseName, 1L,cateId,chapName,
                        pyTime,tcId,tcName,cateId,cateName,coursePro,courseCity,courseArea,ts);
            }

        });

        courseDS.print();

//        SingleOutputStreamOperator<ChapCount> watermarks = courseDS.assignTimestampsAndWatermarks(new BoundedOutOfOrdernessTimestampExtractor<ChapCount>(Time.seconds(2)) {
//            @Override
//            public long extractTimestamp(ChapCount chapCount) {
//                return chapCount.getTs();
//            }
//        });
//
////        watermarks.print();
//
//        KeyedStream<ChapCount, String> keyDS = watermarks.keyBy(new KeySelector<ChapCount, String>() {
//            @Override
//            public String getKey(ChapCount chapCount) throws Exception {
//                return chapCount.getCourName();
//            }
//        });
//
////        keyDS.print();
//
//        AllWindowedStream<ChapCount, TimeWindow> winDS = keyDS.timeWindowAll(Time.seconds(2));
//
//        SingleOutputStreamOperator<ChapCount> reduce = winDS.reduce(new ReduceFunction<ChapCount>() {
//                                                                        @Override
//                                                                        public ChapCount reduce(ChapCount t1, ChapCount t2) throws Exception {
//                                                                            return new ChapCount("", "", 0, t1.getCourName(),
//                                                                                    t1.getCourNameNum() + t2.getCourNameNum(), 0L);
//                                                                        }
//                                                                    },
//                new ProcessAllWindowFunction<ChapCount, ChapCount, TimeWindow>() {
//                    @Override
//                    public void process(Context context, Iterable<ChapCount> iterable, Collector<ChapCount> collector) throws Exception {
//
//                        for (ChapCount chapCount : iterable) {
//
//                            String startDate = DateTimeUtil.todateStr(context.window().getStart());
//                            String endDate = DateTimeUtil.todateStr(context.window().getEnd());
//
//                            chapCount.setStartTime(startDate);
//                            chapCount.setEndTime(endDate);
//                            collector.collect(chapCount);
//                        }
//                    }
//                });
//
//
//        reduce.print();

        env.execute();

    }

}
