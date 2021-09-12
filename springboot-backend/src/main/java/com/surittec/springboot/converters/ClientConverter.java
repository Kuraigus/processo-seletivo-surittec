package com.surittec.springboot.converters;

import com.surittec.springboot.dto.AddressDTO;
import com.surittec.springboot.dto.ClientDTO;
import com.surittec.springboot.dto.PhoneDTO;
import com.surittec.springboot.model.Address;
import com.surittec.springboot.model.Client;
import com.surittec.springboot.model.Phone;
import com.surittec.springboot.utils.ConverterUtils;

import java.util.ArrayList;


public class ClientConverter {

    public static Client convertClientDTOToClient(ClientDTO clientDTO) {
        Client client = ConverterUtils.convertTo(clientDTO, Client.class);
        client.setPhones(new ArrayList<>());
        client.setAddress(ConverterUtils.convertTo(clientDTO.getAddress(), Address.class));
        clientDTO.getPhones().forEach(phone -> client.getPhones()
                .add(ConverterUtils.convertTo(phone, Phone.class)));
        return client;
    }


    public static ClientDTO convertClientToClientDTO(Client client) {
        ClientDTO clientDTO = ConverterUtils.convertTo(client, ClientDTO.class);
        clientDTO.setPhones(new ArrayList<>());
        clientDTO.setAddress(ConverterUtils.convertTo(client.getAddress(), AddressDTO.class));
        client.getPhones().forEach(phone -> clientDTO.getPhones()
                .add(ConverterUtils.convertTo(phone, PhoneDTO.class)));
        return clientDTO;
    }


}
