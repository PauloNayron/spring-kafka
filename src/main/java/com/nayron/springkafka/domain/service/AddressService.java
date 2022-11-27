package com.nayron.springkafka.domain.service;

import com.nayron.springkafka.domain.entity.Address;

public interface AddressService {
    Address getInformationByZipCode(String cep);
}
