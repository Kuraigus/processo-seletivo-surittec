package com.surittec.springboot.model;

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
    private String rua;

    @Column(name = "NEIGHBORHOOD")
    @NotNull(message = "Bairro obrigatorio")
    private String bairro;

    @Column(name = "CITY")
    @NotNull(message = "Cidade obrigatorio")
    private String cidade;

    @Column(name = "STATE")
    @NotNull(message = "UF obrigatorio")
    private String uf;

    @Column(name = "COMPLEMENT")
    private String complemento;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    public Address() {
    }

    public Address(String cep, String rua, String bairro, String cidade, String uf, String complemento) {
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
