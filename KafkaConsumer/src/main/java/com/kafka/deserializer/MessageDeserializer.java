package com.kafka.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.model.Message;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class MessageDeserializer implements Deserializer<Message> {
    @Override
    public Message deserialize(String topic, byte[] data) {
        Message message = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            message = objectMapper.readValue(data, Message.class);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }
}
