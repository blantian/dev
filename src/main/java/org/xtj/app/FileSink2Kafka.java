package org.xtj.app;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.xtj.utils.MyKafkaUtil;

public class FileSink2Kafka {

    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.readTextFile("input/access.log").addSink(MyKafkaUtil.getKafkaSink("access_log"));
        env.execute();

    }

}
