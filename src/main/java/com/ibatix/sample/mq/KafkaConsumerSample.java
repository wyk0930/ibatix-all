package com.ibatix.sample.mq;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public class KafkaConsumerSample {
    public static void main(String[] args) {
        // 配置信息
        Map<String, Object> configs = new HashMap<>();
        // 配置连接信息
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.7.77:9092");
        // 配置key的反序列化器
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
        // 配置value的反序列化器
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        // 配置消费组ID
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, "consumer_demo");
        // 如果找不到当前有效偏移量，自动选择最开始位置
        configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        KafkaConsumer<Integer, String> consumer = new KafkaConsumer<Integer, String>(configs);

        consumer.subscribe(Arrays.asList("tp_demo_01"));
//        consumer.subscribe(Pattern.compile("topic_1"));

        int count = 0;

        while (true) {
            // 指定每隔3秒拉取一次
            ConsumerRecords<Integer, String> consumerRecords = consumer.poll(3000);

            consumerRecords.forEach(new Consumer<ConsumerRecord<Integer, String>>() {
                @Override
                public void accept(ConsumerRecord<Integer, String> record) {
                    System.out.println("消息的主题：" + record.topic());
                    System.out.println("消息分区：" + record.partition() + "\t");
                    System.out.println("消息的偏移量：" + record.offset() + "\t");
                    System.out.println("消息的Key：" + record.key() + "\t");
                    System.out.println("消息的Value：" + record.value() + "\t");
                    System.out.println("=============================================");
                }
            });
            count++;
            if (count == 10) {
                consumer.close();
                break;
            }
        }
    }
}
