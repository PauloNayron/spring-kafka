package com.nayron.springkafka.infraestructure.gateway.viacep;

import com.nayron.springkafka.infraestructure.gateway.viacep.response.AddressResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ViaCepGateway {
    AddressResponse getByCEP(@PathVariable String zipCode);
}
