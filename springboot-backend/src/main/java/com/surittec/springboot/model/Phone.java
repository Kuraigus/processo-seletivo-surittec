package com.surittec.springboot.model;

import com.surittec.springboot.model.dto.PhoneDto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PHONE")
public class Phone {

    @Column(name = "TYPE")
    @NotNull(message = "Tipo do telefone obrigatorio")
    private String type;

    @Column(name = "NUMBER")
    @NotNull(message = "Numero do telefone obrigatorio")
    private String number;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    public Phone() {
    }

    public static Phone from(PhoneDto phoneDto) {
        Phone phone = new Phone();
        phone.setNumber(phoneDto.getNumber());
        phone.setType(phoneDto.getType());
        return phone;
    }

    public Phone(String type, String number) {
        this.type = type;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
