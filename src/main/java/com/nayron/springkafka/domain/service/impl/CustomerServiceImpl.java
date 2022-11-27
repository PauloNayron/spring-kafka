package com.nayron.springkafka.domain.service.impl;

import com.nayron.springkafka.domain.entity.Customer;
import com.nayron.springkafka.domain.service.CustomerService;
import com.nayron.springkafka.domain.service.CustomerTopic;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerTopic customerTopic;

    @Override
    public void publisherNewCustomer(Customer customer) {
        customerTopic.publishNewCustomer(customer);
    }
}
