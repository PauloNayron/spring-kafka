package com.nayron.springkafka.infraestructure.topic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nayron.springkafka.domain.entity.Customer;
import com.nayron.springkafka.domain.service.CustomerTopic;
import com.nayron.springkafka.infraestructure.topic.message.CustomerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomerTopicKafka implements CustomerTopic {
    @Value("${topic.new-customer}") String topicNewCustomer;
    @Autowired private KafkaTemplate<String, String> kafkaTemplate;
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void publishNewCustomer(Customer customer) {
        try {
            CustomerMessage customerMessage = new CustomerMessage(customer);
            var message = objectMapper.writeValueAsString(customerMessage);
            this.kafkaTemplate.send(topicNewCustomer, message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
