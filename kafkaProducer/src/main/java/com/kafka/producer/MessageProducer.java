package com.kafka.producer;

import com.kafka.model.Message;

public interface MessageProducer {
    void publishToQueue(String key, Message message);
}
