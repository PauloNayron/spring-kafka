package com.nayron.springkafka.domain.entity;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record Customer(
        String id,
        String document,
        String name,
        LocalDate birthdate,
        Address address
) {}
