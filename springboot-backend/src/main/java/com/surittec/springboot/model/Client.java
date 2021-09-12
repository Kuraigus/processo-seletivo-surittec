package com.surittec.springboot.model;


import com.surittec.springboot.model.dto.ClientDto;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Entity
@Table(name = "CLIENT")
public class Client {

    @Column(name = "EMAIL")
    @ElementCollection
    @Size(min = 1, message = "Pelo menos 1 email deve ser registrado")
    private List<@Email(message = "Informe um email valido") String> emails;

    @Column(name = "CPF")
    @NotNull(message = "CPF obrigatorio")
    @NotEmpty(message = "CPF nao pode ser vazio")
    @Size(min = 11, max = 11, message = "CPF tem requer no minimo e no maximo 11 caracteres ")
    private String cpf;

    @Column(name = "NAME")
    @Size(min = 3, max = 100, message = "Nome requer no minimo 3 caracteres")
    @NotNull(message = "Nome obrigatorio")
    private String name;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "id")
    @NotNull(message = "Endereco obrigatorio")
    private Address address;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "PHONE_ID", referencedColumnName = "id")
    @Size(min = 1, message = "Pelo menos 1 numero deve ser registrado")
    private List<Phone> phones = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Client() {
    }

    public static Client from(ClientDto clientDto) {
        Client client = new Client();
        client.setEmails(clientDto.getEmails());
        client.setName(clientDto.getName());
        client.setCpf(clientDto.getCpf());
        client.setAddress(clientDto.getAddress());
        client.setPhones(clientDto.getPhones().stream().map(Phone::from).collect(Collectors.toList()));
        return client;
    }

    public Client(List<String> emails, String cpf, String name, Address address, List<Phone> phone) {
        this.emails = emails;
        this.cpf = cpf;
        this.name = name;
        this.address = address;
        this.phones = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void addPhone(Phone phone) {
        phones.add(phone);
    }

    public void removePhone(Phone phone) {
        phones.remove(phone);
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
}
