package com.nayron.springkafka.domain.entity;

import lombok.Builder;

@Builder
public record Address(
        String number,
        String cep,
        String complement,
        String street,
        String district,
        String city,
        String uf,
        String ibge,
        String gia,
        String ddd,
        String siafi
) {}
