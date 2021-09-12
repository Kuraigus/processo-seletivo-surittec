package com.surittec.springboot.model.dto;

import com.surittec.springboot.model.Address;
import com.surittec.springboot.model.Client;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClientDto {

    private Long id;

    @Size(min = 1, message = "Pelo menos 1 email deve ser registrado")
    private List<@Email(message = "Informe um email valido") String> emails;

    @NotNull(message = "CPF obrigatorio")
    @NotEmpty(message = "CPF nao pode ser vazio")
    @Size(min = 11, max = 11, message = "CPF tem requer no minimo e no maximo 11 caracteres ")
    private String cpf;

    @Size(min = 3, max = 100, message = "Nome requer no minimo 3 caracteres")
    @NotNull(message = "Nome obrigatorio")
    private String name;

    @NotNull(message = "Endereco obrigatorio")
    private Address address;

    @Size(min = 1, message = "Pelo menos 1 numero deve ser registrado")
    private List<PhoneDto> phones = new ArrayList<>();


    public static ClientDto from(Client client) {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setEmails(client.getEmails());
        clientDto.setName(client.getName());
        clientDto.setCpf(client.getCpf());
        clientDto.setAddress(client.getAddress());
        clientDto.setPhones(client.getPhones().stream().map(PhoneDto::from).collect(Collectors.toList()));
        return clientDto;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<PhoneDto> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneDto> phones) {
        this.phones = phones;
    }
}
