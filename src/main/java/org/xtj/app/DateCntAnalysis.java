package org.xtj.app;

import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.timestamps.BoundedOutOfOrdernessTimestampExtractor;
import org.apache.flink.streaming.api.functions.windowing.AllWindowFunction;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.util.Collector;
import org.xtj.bean.UserCount;
import org.xtj.utils.DateTimeUtil;
import org.xtj.utils.MyKafkaUtil;
import org.xtj.utils.RegexUtil;


public class DateCntAnalysis {

    private static String topic = "access_log";
    private static String consumerId = "consumer03";

    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        FlinkKafkaConsumer<String> kafkaSource = MyKafkaUtil.getKafkaSource(topic, consumerId);
        SingleOutputStreamOperator<String> accessLogDS = env.addSource(kafkaSource)
                .filter(x -> x.length() > 10 && x.split(" ").length > 2);

//        accessLogDS.print();

        SingleOutputStreamOperator<UserCount> userCountDS = accessLogDS.map(new RichMapFunction<String, UserCount>() {
            @Override
            public UserCount map(String s) throws Exception {
                //获取时间
                String[] strings = s.split(" ");
                String dateStr = DateTimeUtil.toYMDhms(strings[0].split("\\|")[0]);
                Long ts = DateTimeUtil.toTS(dateStr);
                String behavior = strings[1];
                Float pt = RegexUtil.findPlaytime(behavior);
                return new UserCount("", "", 1L,ts,pt);
            }
        });


        SingleOutputStreamOperator<UserCount> watermarks = userCountDS
                .assignTimestampsAndWatermarks(new BoundedOutOfOrdernessTimestampExtractor<UserCount>(Time.seconds(2)) {
                    @Override
                    public long extractTimestamp(UserCount userCount) {
                        return userCount.getTs();
                    }
                });


        SingleOutputStreamOperator<UserCount> cntDS = watermarks.timeWindowAll(Time.seconds(5))  //直接不分组 基于DS开一小时窗口
                .apply(new AllWindowFunction<UserCount, UserCount, TimeWindow>() {
                    @Override
                    public void apply(TimeWindow timeWindow, Iterable<UserCount> iterable, Collector<UserCount> collector) throws Exception {
                        long sum = 0L;
                        Float pt_sum = 0f;
                        for (UserCount userCount : iterable) {
                            sum += 1;
                            pt_sum += userCount.getPt();
                        }
                        collector.collect(new UserCount(DateTimeUtil.todateStr(timeWindow.getStart()), DateTimeUtil.todateStr(timeWindow.getEnd()), sum, 0L,pt_sum));
                    }
                });

        cntDS.print();

        env.execute();

    }

}
