package com.ibatix.sample.web;

import org.apache.kafka.common.serialization.Deserializer;

import java.nio.ByteBuffer;
import java.util.Map;

public class UserDeserializer implements Deserializer<UserModel> {
    @Override
    public void configure(Map<String, ?> map, boolean b) {

    }

    @Override
    public UserModel deserialize(String s, byte[] data) {
        ByteBuffer buff = ByteBuffer.allocate(data.length);
        buff.put(data);
        buff.flip();

        int userId = buff.getInt();
        int usernameLength = buff.getInt();

        String username = new String(data, 8, usernameLength);
        UserModel user = new UserModel();
        user.setUserId(userId);
        user.setUsername(username);

        return user;
    }

    @Override
    public void close() {

    }
}
