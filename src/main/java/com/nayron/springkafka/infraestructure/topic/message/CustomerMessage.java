package com.nayron.springkafka.infraestructure.topic.message;

import com.nayron.springkafka.domain.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMessage {
    @NotBlank(message = "document cannot be blank")
    private String document;
    @NotBlank(message = "name cannot be blank")
    private String name;
    private LocalDate birthdate;
    private AddressMessage address;

    public CustomerMessage(Customer customer) {
        this.document = customer.document();
        this.name = customer.name();
        this.birthdate = customer.birthdate();
        this.address = new AddressMessage(customer.address());
    }
}
