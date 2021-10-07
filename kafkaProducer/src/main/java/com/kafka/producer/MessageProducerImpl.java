package com.kafka.producer;

import com.kafka.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerImpl implements MessageProducer{
    private static final String TOPIC = "message.topic";

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    @Override
    public void publishToQueue(String key, Message message) {
        kafkaTemplate.send(TOPIC, key, message);
    }
}
