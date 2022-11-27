package com.nayron.springkafka.application.controller;

import com.nayron.springkafka.domain.service.MessageService;
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

    private MessageService messageService;

    @PostMapping
    public ResponseEntity<String> publishMessage(@RequestBody String message) {
        messageService.sendMessage(message);
        return ResponseEntity.accepted().body(message);
    }
}
