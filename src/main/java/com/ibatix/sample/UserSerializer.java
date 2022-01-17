package com.ibatix.sample;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class UserSerializer implements Serializer<User> {
    @Override
    public void configure(Map<String, ?> map, boolean b) {
        // do nothing.
        // 用于接收对序理化器的配置参数，并对当前序列化器进行初始化
    }

    @Override
    public byte[] serialize(String s, User user) {
        if (user == null) return null;

        Integer userId = user.getUserId();
        String username = user.getUsername();
        ByteBuffer buffer = null;
        try {
            if (userId != null && username != null) {
                byte[] binaryUsername = username.getBytes(StandardCharsets.UTF_8);

                // 用户ID（Int类型长度为4bytes）
                int length = 4;
                // 用于存储用序列化后数所的长度（Int类型长度为4bytes）
                length += 4;
                // 用于存储用户名序列化数据（bytes[]长度）
                length += binaryUsername.length;

                buffer = ByteBuffer.allocate(length);
                buffer.putInt(userId); // 用户ID
                buffer.putInt(binaryUsername.length); // 用户名序列化数据的长度
                buffer.put(binaryUsername); // 用户名序列化数据

                return buffer.array();
            }
        } catch (Exception e) {
            throw new SerializationException("序列化失败", e);
        }
        return buffer.array();
    }

    @Override
    public void close() {
        // do nothing
    }
}
