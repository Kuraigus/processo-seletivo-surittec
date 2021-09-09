package com.surittec.springboot.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PHONE")
public class Phone {

    @Column(name = "TYPE")
    @NotNull(message = "Tipo do telefone obrigatorio")
    private String tipo;

    @Column(name = "NUMBER")
    @NotNull(message = "Numero do telefone obrigatorio")
    private String numero;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    public Phone() {
    }

    public Phone(String tipo, String numero) {
        this.tipo = tipo;
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
