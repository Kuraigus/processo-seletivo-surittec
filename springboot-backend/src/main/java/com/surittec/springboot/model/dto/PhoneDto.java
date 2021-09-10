package com.surittec.springboot.model.dto;

import com.surittec.springboot.model.Phone;

import javax.validation.constraints.NotNull;

public class PhoneDto {

    private Long id;

    @NotNull(message = "Tipo do telefone obrigatorio")
    private String type;

    @NotNull(message = "Numero do telefone obrigatorio")
    private String number;

    public static PhoneDto from(Phone phone) {
        PhoneDto phoneDto = new PhoneDto();
        phoneDto.setId(phone.getId());
        phoneDto.setNumber(phone.getNumber());
        phoneDto.setType(phone.getType());
        return phoneDto;
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
