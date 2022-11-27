package com.nayron.springkafka.domain.service.impl;

import com.nayron.springkafka.domain.entity.Address;
import com.nayron.springkafka.domain.service.AddressService;
import com.nayron.springkafka.domain.service.ZipCodeGateway;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private ZipCodeGateway zipCodeGateway;

    @Override
    public Address getInformationByZipCode(String zipCode) {
        Address address = zipCodeGateway.getAddressByZipCode(zipCode);
        return null;
    }
}
