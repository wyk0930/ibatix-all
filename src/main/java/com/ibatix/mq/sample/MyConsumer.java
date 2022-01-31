package com.ibatix.mq.sample;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class MyConsumer {
    public static final String BROKER = "192.168.7.77:9092";
    public static final String KEY_DESERIALIZER = "org.apache.kafka.common.serialization.StringDeserializer";
    public static final String VALUE_DESERIALIZER = "org.apache.kafka.common.serialization.StringDeserializer";

    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER);
        props.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, KEY_DESERIALIZER);
        props.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, VALUE_DESERIALIZER);
        props.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "mygrp");
        // props.setProperty(ConsumerConfig.CLIENT_ID_CONFIG, "myclient");
        // 如果在kafka中找不到当前消费者的偏移量，则设置为最旧的
        props.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        // 配置拦截器
        // One -> Two -> Three，接收消息和发送偏移量确认都是这个顺序

        props.setProperty(ConsumerConfig.INTERCEPTOR_CLASSES_CONFIG
                , "com.ibatix.mq.sample.FirstInterceptor"
                        + ", com.ibatix.mq.sample.SecondInterceptor"
                        + ", com.ibatix.mq.sample.ThirdInterceptor"
        );
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        // 订阅主题
        consumer.subscribe(Collections.singleton("tp_demo_01"));
        while (true) {
            final ConsumerRecords<String, String> records = consumer.poll(3_000);
            records.forEach(record -> {
                System.out.println(record.topic()
                        + "\t" + record.partition()
                        + "\t" + record.offset()
                        + "\t" + record.key()
                        + "\t" + record.value());
            });
            // consumer.commitAsync();
            // consumer.commitSync();
        }
        // consumer.close();
    }
}
