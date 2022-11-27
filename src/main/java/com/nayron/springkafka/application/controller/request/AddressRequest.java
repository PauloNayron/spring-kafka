package com.nayron.springkafka.application.controller.request;

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
public class AddressRequest {
    private String number;
    @NotBlank
    private String cep;
    private String complement;

    public Address toEntity() {
        return Address.builder()
                .number(this.number)
                .cep(this.cep)
                .complement(this.complement)
                .build();
    }
}
