package com.surittec.springboot.model.dto;

import com.surittec.springboot.model.Address;
import com.surittec.springboot.model.Client;
import com.surittec.springboot.model.Phone;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class ClientDto {

    @Size(min = 1, message = "Pelo menos 1 email deve ser registrado")
    private List<String> emails;

    @NotNull(message = "Nome obrigatorio")
    private String cpf;

    @Size(min = 3, max = 100)
    @NotNull(message = "Nome obrigatorio")
    private String name;

    @NotNull(message = "Endereco obrigatorio")
    private Address address;

    @Size(min = 1, message = "Pelo menos 1 numero deve ser registrado")
    private List<Phone> phones = new ArrayList<>();


    public static ClientDto from(Client client) {
        ClientDto clientDto = new ClientDto();
        clientDto.setEmails(client.getEmails());
        clientDto.setName(client.getName());
        clientDto.setCpf(client.getCpf());
        clientDto.setAddress(client.getAddress());
        return clientDto;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
