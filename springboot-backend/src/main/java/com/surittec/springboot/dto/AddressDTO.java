package com.surittec.springboot.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddressDTO {

    private Long id;

    @NotNull(message = "CEP obrigatorio")
    private String cep;

    @NotNull(message = "Rua obrigatorio")
    private String street;

    @NotNull(message = "Bairro obrigatorio")
    private String neighborhood;

    @NotNull(message = "Cidade obrigatorio")
    private String city;

    @NotNull(message = "UF obrigatorio")
    private String state;

    private String complement;
}
