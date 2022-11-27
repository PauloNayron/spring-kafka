package com.nayron.springkafka.application.controller.response;

import com.nayron.springkafka.domain.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    private String id;
    public CustomerResponse(Customer customer) {
        this.id = customer.id();
    }
}
