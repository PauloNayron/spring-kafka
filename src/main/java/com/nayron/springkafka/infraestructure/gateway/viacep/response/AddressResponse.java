package com.nayron.springkafka.infraestructure.gateway.viacep.response;

import com.nayron.springkafka.domain.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    public Address toEntity() {
        return Address.builder()
                .cep(this.cep)
                .street(this.logradouro)
                .complement(this.complemento)
                .district(this.bairro)
                .city(this.localidade)
                .uf(this.uf)
                .ibge(this.ibge)
                .gia(this.gia)
                .ddd(this.ddd)
                .siafi(this.siafi)
                .build();
    }
}
