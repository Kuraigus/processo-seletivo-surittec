package com.surittec.springboot.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "CLIENTE")
public class Client {

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PHONE")
    @Size(min = 1, message = "Pelo menos 1 numero deve ser registrado")
    private List<Phone> telefones;

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
    private String nome;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ADDRESS")
    private Address endereco;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    public Client() {
    }

    public Client(List<Phone> telefones, List<String> emails, String cpf, String nome, Address endereco, long id) {
        this.telefones = telefones;
        this.emails = emails;
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.id = id;
    }

    public List<Phone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Phone> telefones) {
        this.telefones = telefones;
    }

    public Address getEndereco() {
        return endereco;
    }

    public void setEndereco(Address endereco) {
        this.endereco = endereco;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
