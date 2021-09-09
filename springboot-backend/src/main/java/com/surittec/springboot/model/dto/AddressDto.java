package com.surittec.springboot.model.dto;

import com.surittec.springboot.model.Address;

import javax.validation.constraints.NotNull;

public class AddressDto {
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

    public static AddressDto from(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setCep(address.getCep());
        addressDto.setCity(address.getCity());
        addressDto.setComplement(address.getComplement());
        addressDto.setNeighborhood(address.getNeighborhood());
        addressDto.setState(address.getState());
        addressDto.setStreet(address.getStreet());
        return addressDto;
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
