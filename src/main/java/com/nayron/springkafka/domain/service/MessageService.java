package com.nayron.springkafka.domain.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class MessageService {
    @Value("${topic.test}") private String topicTest;
    @Autowired private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        log.info(message);
        this.kafkaTemplate.send(topicTest, message);
    }
}
