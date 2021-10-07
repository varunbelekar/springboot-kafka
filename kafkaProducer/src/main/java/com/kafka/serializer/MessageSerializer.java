package com.kafka.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.model.Message;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.stereotype.Component;


public class MessageSerializer implements Serializer<Message> {
    @Override
    public byte[] serialize(String s, Message message) {
        byte[] serializedValue = null;
        ObjectMapper om = new ObjectMapper();
        if(message != null) {
            try {
                serializedValue = om.writeValueAsString(message).getBytes();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return serializedValue;
    }
}
