package com.nayron.springkafka.domain.service;

import com.nayron.springkafka.domain.entity.Customer;

public interface CustomerTopic {
    void publishNewCustomer(Customer customer);
}
