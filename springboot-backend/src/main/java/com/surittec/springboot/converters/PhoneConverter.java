package com.surittec.springboot.converters;

import com.surittec.springboot.dto.PhoneDTO;
import com.surittec.springboot.model.Phone;
import com.surittec.springboot.utils.ConverterUtils;

public class PhoneConverter {

    public static Phone convertPhoneDTOTOPhone(PhoneDTO phoneDTO) {
        return ConverterUtils.convertTo(phoneDTO, Phone.class);
    }

    public static PhoneDTO convertPhoneToPhoneDTO(Phone phone) {
        return ConverterUtils.convertTo(phone, PhoneDTO.class);
    }

}
