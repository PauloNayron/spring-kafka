package com.nayron.springkafka.domain.service;

import com.nayron.springkafka.domain.entity.Customer;

public interface CustomerService {
    void publisherNewCustomer(Customer customer);
}
