package com.nayron.springkafka.infraestructure.topic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nayron.springkafka.domain.entity.Customer;
import com.nayron.springkafka.domain.usecase.NewAddressUseCase;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AddressTopicKafka {
    private NewAddressUseCase newAddressUseCase;
    ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "${topic.new-customer}", groupId = "address-group")
    public void consumerNewCustomerTopic(String message) {
        try {
            Customer customer = objectMapper.readValue(message, Customer.class);
            newAddressUseCase.exec(customer);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
