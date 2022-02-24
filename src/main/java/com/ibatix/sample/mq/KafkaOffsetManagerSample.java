package com.ibatix.sample.mq;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.*;
import java.util.function.BiConsumer;

public class KafkaOffsetManagerSample {
    public static void main(String[] args) {
        Map<String, Object> configs = new HashMap<>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "node001.centos7.local:9092");
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, "mygrp1");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(configs);

//        consumer.subscribe(Collections.singleton("tp_demo_01"));
        // 获取当前消费者可以访问的主题及分区信息
        Map<String, List<PartitionInfo>> topicsMappings = consumer.listTopics();

        topicsMappings.forEach(new BiConsumer<String, List<PartitionInfo>>() {
            @Override
            public void accept(String topicName, List<PartitionInfo> partitionInfos) {
                System.out.println("主题名称：" + topicName);
                for (PartitionInfo partitionInfo : partitionInfos) {
                    System.out.println(partitionInfo);
                }
            }
        });
        System.out.println("=============================================");

        // 获取给当前消费者分配的主题及分区信息
        Set<TopicPartition> assignment = consumer.assignment();
        for (TopicPartition topicPartition : assignment) {
            System.out.println(topicPartition);
        }
        System.out.println("=============================================");
        // 给当前消费者分配指定的主题及分区
        consumer.assign(Arrays.asList(
                new TopicPartition("tp_demo_01", 0),
                new TopicPartition("tp_demo_01", 1),
                new TopicPartition("tp_demo_01", 2)
        ));
        assignment = consumer.assignment();
        for (TopicPartition topicPartition : assignment) {
            System.out.println(topicPartition);
        }

        System.out.println("=============================================");


        long offset = consumer.position(new TopicPartition("tp_demo_01", 1));

        System.out.println("当前主题在0号分区上的位移:" + offset);
        System.out.println("=============================================");

        consumer.seekToBeginning(Arrays.asList(
                new TopicPartition("tp_demo_01", 0),
                new TopicPartition("tp_demo_01", 2)
        ));
        offset = consumer.position(new TopicPartition("tp_demo_01", 0));
        System.out.println("当前主题在0号分区上的位移:" + offset);
        offset = consumer.position(new TopicPartition("tp_demo_01", 1));
        System.out.println("当前主题在1号分区上的位移:" + offset);
        offset = consumer.position(new TopicPartition("tp_demo_01", 2));
        System.out.println("当前主题在2号分区上的位移:" + offset);
        System.out.println("=============================================");
        consumer.seekToEnd(Arrays.asList(
                new TopicPartition("tp_demo_01", 2)
        ));
        offset = consumer.position(new TopicPartition("tp_demo_01", 0));
        System.out.println("当前主题在0号分区上的位移:" + offset);
        offset = consumer.position(new TopicPartition("tp_demo_01", 1));
        System.out.println("当前主题在1号分区上的位移:" + offset);
        offset = consumer.position(new TopicPartition("tp_demo_01", 2));
        System.out.println("当前主题在2号分区上的位移:" + offset);

        consumer.close();
    }
}
