package com.surittec.springboot.controller;

import com.surittec.springboot.model.Client;
import com.surittec.springboot.model.dto.ClientDto;
import com.surittec.springboot.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    private final ClientServices clientServices;

    @Autowired
    public ClientController(ClientServices clientServices) {
        this.clientServices = clientServices;
    }

    @PostMapping
    public ResponseEntity<ClientDto> createClient(@RequestBody final ClientDto clientDto) {
        Client client = clientServices.addClient(Client.from(clientDto));
        return new ResponseEntity<>(clientDto.from(client), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> getClient() {
        List<Client> clients = clientServices.getClients();
        List<ClientDto> clientsDto = clients.stream().map(ClientDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(clientsDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable final Long id) throws Exception{
        Client client = clientServices.getClientById(id);
        return new ResponseEntity<>(ClientDto.from(client), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<ClientDto> deleteClientById(@PathVariable final Long id) throws Exception {
        Client client = clientServices.deleteClient(id);
        return new ResponseEntity<>(ClientDto.from(client), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<ClientDto> updateClientById(@PathVariable final Long id, @RequestBody final ClientDto clientDto) throws Exception {
        Client client = clientServices.updateClient(id, Client.from(clientDto));
        return new ResponseEntity<>(ClientDto.from(client), HttpStatus.OK);
    }

    @PostMapping(value = "{clientId}/phones/{phoneId}/add")
    public ResponseEntity<ClientDto> addPhoneToClient(@PathVariable final Long clientId, @PathVariable final Long phoneId) throws Exception {
        Client client = clientServices.addPhoneToClient(clientId, phoneId);
        return new ResponseEntity<>(ClientDto.from(client), HttpStatus.OK);
    }

    @DeleteMapping(value = "{clientId}/phones/{phoneId}/remove")
    public ResponseEntity<ClientDto> removePhoneFromClient(@PathVariable final Long clientId, @PathVariable final Long phoneId) throws Exception {
        Client client = clientServices.removePhoneFromClient(clientId, phoneId);
        return new ResponseEntity<>(ClientDto.from(client), HttpStatus.OK);
    }
}
