package com.nayron.springkafka.domain.usecase;

import com.nayron.springkafka.domain.entity.Customer;
import com.nayron.springkafka.domain.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateCustomerUseCase {
    private CustomerService customerService;
    public Customer exec(Customer customer) {
        customerService.publisherNewCustomer(customer);
        return customer;
    }
}
