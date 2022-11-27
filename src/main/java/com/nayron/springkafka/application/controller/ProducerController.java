package com.nayron.springkafka.application.controller;

import com.nayron.springkafka.infraestructure.topic.PublisherKafka;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publisher")
@AllArgsConstructor
public class ProducerController {

    private PublisherKafka publisherKafka;

    @PostMapping
    public ResponseEntity<String> publishMessage(@RequestBody String message) {
        publisherKafka.sendMessage(message);
        return ResponseEntity.accepted().body(message);
    }
}
