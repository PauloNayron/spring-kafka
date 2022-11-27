package com.nayron.springkafka.infraestructure.gateway.viacep;

import com.nayron.springkafka.domain.entity.Address;
import com.nayron.springkafka.domain.service.ZipCodeGateway;
import com.nayron.springkafka.infraestructure.gateway.viacep.response.AddressResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ZipCodeGatewayViaCep implements ZipCodeGateway {

    @Override
    public Address getAddressByZipCode(String zipCode) {
//        AddressResponse response = viaCepGateway.getByCEP(zipCode);
        return Address.builder().build();
    }
}
