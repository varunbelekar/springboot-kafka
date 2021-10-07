package com.kafka.controller;

import com.kafka.model.Message;
import com.kafka.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publish")
public class PublishMessageController {
    @Autowired
    private MessageProducer messageProducer;

    @PostMapping
    public String publishMessage(@RequestBody Message message, @RequestParam String key){
        messageProducer.publishToQueue(key, message);
        return "Message published successfully";
    }

    @GetMapping
    public String helloWorld(){
        return "Hello world";
    }
}
