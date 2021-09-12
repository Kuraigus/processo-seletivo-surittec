package com.surittec.springboot.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class ClientDTO {

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
    private AddressDTO address;

    @Size(min = 1, message = "Pelo menos 1 numero deve ser registrado")
    private List<PhoneDTO> phones;

}
