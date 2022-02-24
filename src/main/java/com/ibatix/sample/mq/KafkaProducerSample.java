package com.ibatix.sample.mq;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Future;

public class KafkaProducerSample {
    public static void main(String[] args) throws Exception {
        HashMap<String, Object> configs = new HashMap<>();
        // 指定Broker连接信息
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        // 指定Key的序列化类
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        // 指定Value的序列化类
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        // 根据配置信息，创建Producer
        KafkaProducer<Integer, String> producer = new KafkaProducer<>(configs);

        // 自定义消息头
        List<Header> headers = new ArrayList<>();
        headers.add(new RecordHeader("biz.name", "producer.demo".getBytes(StandardCharsets.UTF_8)));
        // 创建消息请求
        ProducerRecord<Integer, String> recordBySync = new ProducerRecord<>("topic_1", 0, 0, "hello, kafka!(by sync)", headers);

        // TODO 同步获取请求
        syncMode(recordBySync, producer);

        ProducerRecord<Integer, String> recordByAsync = new ProducerRecord<>("topic_1", 0, 0, "hello, kafka!(by async)", headers);
        // TODO 异步请求
        asyncMode(recordByAsync, producer);

        // 释放资源
        producer.close();
    }

    /**
     * 异步确认消息
     *
     * @param record
     * @param producer
     * @throws Exception
     */
    private static void asyncMode(ProducerRecord<Integer, String> record, KafkaProducer<Integer, String> producer) throws Exception {
        // 发送请求
        // 异步处理请求需要在发送时指定callback
        producer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                System.out.println("============================================");

                if (e == null) {
                    System.out.println("消息的主题：" + recordMetadata.topic());
                    System.out.println("消息的分区：" + recordMetadata.partition());
                    System.out.println("消息的偏移量：" + recordMetadata.offset());
                } else {
                    System.out.println("系统异常：" + e.getMessage());
                }
                System.out.println("============================================");

            }
        });
    }

    /**
     * 同步确认消息
     *
     * @param record
     * @param producer
     */
    private static void syncMode(ProducerRecord<Integer, String> record, KafkaProducer<Integer, String> producer) throws Exception {
        // 发送请求
        Future<RecordMetadata> future = producer.send(record);
        System.out.println("============================================");

        // 同步获取请求
        RecordMetadata metadata = future.get();
        System.out.println("消息的主题：" + metadata.topic());
        System.out.println("消息的分区：" + metadata.partition());
        System.out.println("消息的偏移量：" + metadata.offset());
        System.out.println("============================================");

    }
}
