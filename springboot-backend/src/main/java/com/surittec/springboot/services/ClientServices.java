package com.surittec.springboot.services;

import com.surittec.springboot.exception.ResourceNotFoundException;
import com.surittec.springboot.model.Address;
import com.surittec.springboot.model.Client;
import com.surittec.springboot.model.Phone;
import com.surittec.springboot.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServices {

    private ClientRepository clientRepository;
    private AddressService addressService;
    private PhoneService phoneService;

    @Autowired
    public ClientServices(ClientRepository clientRepository, AddressService addressService, PhoneService phoneService) {
        this.clientRepository = clientRepository;
        this.addressService = addressService;
        this.phoneService = phoneService;
    }


    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) throws Exception {
        return clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente com id: " + id + " nao encontrado"));
    }

    public Client deleteClient(Long id) throws Exception {
        Client client = getClientById(id);
        clientRepository.delete(client);
        return client;
    }

    public Client updateClient(Long id, Client client) throws Exception {
        Client clientToEdit = getClientById(id);
        clientToEdit.setEmails(client.getEmails());
        clientToEdit.setName(client.getName());
        clientToEdit.setCpf(client.getCpf());
        clientToEdit.setAddress(client.getAddress());
        return clientToEdit;
    }

    public Client addPhoneToClient(Long clientId, Long phoneid) throws Exception {
        Client client = getClientById(clientId);
        Phone phone = phoneService.getPhoneById(phoneid);
        client.addPhone(phone);
        return client;
    }

    public Client removePhoneFromClient(Long clientId, Long phoneId) throws Exception {
        Client client = getClientById(clientId);
        Phone phone = phoneService.getPhoneById(phoneId);
        client.removePhone(phone);
        return client;
    }

    public Client addAddressToClient(Long clientId, Long addressId) throws Exception{
        Client client = getClientById(clientId);
        Address address = addressService.getAddressById(addressId);
        client.setAddress(address);
        return client;
    }
}
