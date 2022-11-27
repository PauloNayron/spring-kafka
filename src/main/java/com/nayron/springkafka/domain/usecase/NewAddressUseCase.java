package com.nayron.springkafka.domain.usecase;

import com.nayron.springkafka.domain.entity.Address;
import com.nayron.springkafka.domain.entity.Customer;
import com.nayron.springkafka.domain.service.AddressService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class NewAddressUseCase {
    public AddressService addressService;

    public void exec(Customer customer) {
        Address addressCustomer = customer.address();
        Address address = addressService.getInformationByZipCode(addressCustomer.cep());
        Address addressMerge = Address.builder()
                .number(addressCustomer.number())
                .cep(addressCustomer.cep())
                .complement(addressCustomer.complement())
                .street(address.street())
                .district(address.district())
                .city(address.city())
                .uf(address.uf())
                .ibge(address.ibge())
                .gia(address.gia())
                .ddd(address.ddd())
                .siafi(address.siafi())
                .build();
        log.info(String.format("merge address: %s", addressMerge.toString()));
    }
}
