package com.surittec.springboot.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "ADDRESS")
public class Address {

    @Column(name = "CEP")
    @NotNull(message = "CEP obrigatorio")
    private String cep;

    @Column(name = "STREET")
    @NotNull(message = "Rua obrigatorio")
    private String street;

    @Column(name = "NEIGHBORHOOD")
    @NotNull(message = "Bairro obrigatorio")
    private String neighborhood;

    @Column(name = "CITY")
    @NotNull(message = "Cidade obrigatorio")
    private String city;

    @Column(name = "STATE")
    @NotNull(message = "UF obrigatorio")
    private String state;

    @Column(name = "COMPLEMENT")
    private String complement;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
