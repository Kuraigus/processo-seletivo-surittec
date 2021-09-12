package com.surittec.springboot.dto;

import com.surittec.springboot.types.PhoneTypes;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PhoneDTO {

    private Long id;

    @NotNull(message = "Tipo do telefone obrigatorio")
    private PhoneTypes type;

    @NotNull(message = "Numero do telefone obrigatorio")
    private String number;
}
