package com.surittec.springboot.model;

import com.surittec.springboot.types.PhoneTypes;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "PHONE")
public class Phone {

    @Column(name = "TYPE")
    @NotNull(message = "Tipo do telefone obrigatorio")
    private PhoneTypes type;

    @Column(name = "NUMBER")
    @NotNull(message = "Numero do telefone obrigatorio")
    private String number;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
