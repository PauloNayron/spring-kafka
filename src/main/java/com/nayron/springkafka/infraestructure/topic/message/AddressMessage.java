package com.nayron.springkafka.infraestructure.topic.message;

import com.nayron.springkafka.domain.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressMessage {
    private String number;
    @NotBlank
    private String cep;
    private String complement;

    public AddressMessage(Address address) {
        this.number = address.number();
        this.cep = address.cep();
        this.complement = address.complement();
    }
}
