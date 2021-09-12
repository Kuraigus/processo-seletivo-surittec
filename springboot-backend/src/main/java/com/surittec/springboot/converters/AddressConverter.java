package com.surittec.springboot.converters;

import com.surittec.springboot.dto.AddressDTO;
import com.surittec.springboot.model.Address;
import com.surittec.springboot.utils.ConverterUtils;

public class AddressConverter {

    public static Address convertAddressDTOToAddress(AddressDTO addressDTO) {
        return ConverterUtils.convertTo(addressDTO, Address.class);
    }

    public static AddressDTO convertAddressToAddressDTO(Address address) {
        return ConverterUtils.convertTo(address, AddressDTO.class);
    }

}
