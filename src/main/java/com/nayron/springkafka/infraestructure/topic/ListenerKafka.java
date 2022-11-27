package com.nayron.springkafka.infraestructure.topic;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ListenerKafka {

    @KafkaListener(topics = "${topic.test}", groupId = "group_id")
    public void consumer(String message) {
        log.info("consumer" + message);
    }
}
