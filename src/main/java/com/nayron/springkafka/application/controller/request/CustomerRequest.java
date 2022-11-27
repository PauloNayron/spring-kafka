package com.nayron.springkafka.application.controller.request;

import com.nayron.springkafka.domain.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    @NotBlank(message = "document cannot be blank")
    private String document;
    @NotBlank(message = "name cannot be blank")
    private String name;
    private LocalDate birthdate;
    private AddressRequest address;

    public Customer toEntity() {
        return Customer.builder()
                .id(UUID.randomUUID().toString())
                .document(this.document)
                .name(this.name)
                .birthdate(this.birthdate)
                .address(this.address.toEntity())
                .build();
    }
}
