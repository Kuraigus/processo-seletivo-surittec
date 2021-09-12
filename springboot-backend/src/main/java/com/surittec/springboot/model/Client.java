package com.surittec.springboot.model;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name = "CLIENT")
public class Client {

    @Column(name = "EMAIL")
    @ElementCollection
    @Size(min = 1, message = "Pelo menos 1 email deve ser registrado")
    private List<@Email(message = "Informe um email valido") String> emails;

    @Column(name = "CPF")
    @NotNull(message = "CPF obrigatorio")
    @CPF(message= "CPF informado invalido")
    private String cpf;

    @Column(name = "NAME")
    @Size(min = 3, max = 100, message = "Nome requer no minimo 3 caracteres")
    @NotNull(message = "Nome obrigatorio")
    @Pattern(regexp = "^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$")
    private String name;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "id")
    @NotNull(message = "Endereco obrigatorio")
    private Address address;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "PHONE_ID", referencedColumnName = "id")
    @Size(min = 1, message = "Pelo menos 1 numero deve ser registrado")
    private List<Phone> phones;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    public void addPhone(Phone phone) {
        phones.add(phone);
    }

    public void removePhone(Phone phone) {
        phones.remove(phone);
    }

    public void addEmail(String email) {
        emails.add(email);
    }

    public void removeEmail(String email) {
        emails.remove(email);
    }
}
