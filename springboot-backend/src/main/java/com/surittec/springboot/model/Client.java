package com.surittec.springboot.model;

import com.surittec.springboot.model.dto.AddressDto;
import com.surittec.springboot.model.dto.ClientDto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CLIENT")
public class Client {
    @Column(name = "EMAIL")
    @ElementCollection
    @Size(min = 1, message = "Pelo menos 1 email deve ser registrado")
    private List<String> emails;

    @Column(name = "CPF")
    @NotNull(message = "Nome obrigatorio")
    private String cpf;

    @Column(name = "NAME")
    @Size(min = 3, max = 100)
    @NotNull(message = "Nome obrigatorio")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @NotNull(message = "Endereco obrigatorio")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    @Size(min = 1, message = "Pelo menos 1 numero deve ser registrado")
    private List<Phone> phones = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Client() {
    }

    public static Client from(ClientDto clientDto) {
        Client client = new Client();
        client.setEmails(clientDto.getEmails());
        client.setName(clientDto.getName());
        client.setCpf(clientDto.getCpf());
        client.setAddress(clientDto.getAddress());
        return client;
    }

    public Client(List<String> emails, String cpf, String name, Address address, List<Phone> phone) {
        this.emails = emails;
        this.cpf = cpf;
        this.name = name;
        this.address = address;
        this.phones = phone;
    }

    public Address getAddress() {
        return address;
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
