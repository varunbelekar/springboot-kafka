package com.kafka.consumer;

import com.kafka.model.Message;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    private static final String TOPIC = "message.topic";

    @KafkaListener(topics = TOPIC)
    public void messageListner(ConsumerRecord<String, Message> consumerRecord, Acknowledgment acknowledgment){
        String key = consumerRecord.key();
        Message value = consumerRecord.value();
        int partition = consumerRecord.partition();
        System.out.println("Read message with key: " + key + " value: " + value + " partition: " + partition);
        acknowledgment.acknowledge();
    }
}
