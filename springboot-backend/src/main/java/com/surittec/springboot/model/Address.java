package com.surittec.springboot.model;

import com.surittec.springboot.model.dto.AddressDto;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

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


    public Address() {
    }

    public static Address from(AddressDto addressDto) {
        Address address = new Address();
        address.setStreet(addressDto.getStreet());
        address.setState(addressDto.getState());
        address.setNeighborhood(addressDto.getNeighborhood());
        address.setComplement(addressDto.getComplement());
        address.setCity(addressDto.getCity());
        address.setCep(addressDto.getCep());
        return address;
    }

    public Address(String cep, String street, String neighborhood, String city, String state, String complement) {
        this.cep = cep;
        this.street = street;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.complement = complement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}
