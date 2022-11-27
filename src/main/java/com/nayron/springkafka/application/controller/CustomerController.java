package com.nayron.springkafka.application.controller;

import com.nayron.springkafka.application.controller.request.CustomerRequest;
import com.nayron.springkafka.application.controller.response.CustomerResponse;
import com.nayron.springkafka.domain.usecase.CreateCustomerUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer-service/v1")
@AllArgsConstructor
public class CustomerController {
    private CreateCustomerUseCase createCustomerUseCase;

    @PostMapping("customer")
    public ResponseEntity<CustomerResponse> publishMessage(
            @Valid @RequestBody CustomerRequest customerRequest
    ) {
        var customer = createCustomerUseCase.exec(customerRequest.toEntity());
        return ResponseEntity.accepted().body(new CustomerResponse(customer));
    }
}
