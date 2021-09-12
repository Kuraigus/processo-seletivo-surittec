package com.surittec.springboot.controller;

import com.surittec.springboot.model.Client;
import com.surittec.springboot.model.dto.ClientDto;
import com.surittec.springboot.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/clientes")
public class ClientController extends AbstractController {

    private final ClientServices clientServices;

    @Autowired
    public ClientController(ClientServices clientServices) {
        this.clientServices = clientServices;
    }

    @PostMapping
    public ResponseEntity<?> createClient(@RequestBody final ClientDto clientDto) {
        return buildResponse(() -> clientServices.addClient(Client.from(clientDto)));
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> getClient() {

        return buildResponse(() -> {
            List<Client> clients = clientServices.getClients();
            List<ClientDto> clientsDto = clients.stream().map(ClientDto::from).collect(Collectors.toList());
            return clientsDto;
        });

    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable final Long id) {
        return buildResponse(() -> clientServices.getClientById(id));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteClientById(@PathVariable final Long id) {
        return buildResponse(() -> clientServices.deleteClient(id));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<ClientDto> updateClientById(@PathVariable final Long id, @RequestBody final ClientDto clientDto) {
        return buildResponse(() -> clientServices.updateClient(id, Client.from(clientDto)));

    }

    @PostMapping(value = "{clientId}/phones/{phoneId}/add")
    public ResponseEntity<ClientDto> addPhoneToClient(@PathVariable final Long clientId, @PathVariable final Long phoneId) {
        return buildResponse(() -> clientServices.addPhoneToClient(clientId, phoneId));

    }

    @DeleteMapping(value = "{clientId}/phones/{phoneId}/remove")
    public ResponseEntity<ClientDto> removePhoneFromClient(@PathVariable final Long clientId, @PathVariable final Long phoneId) {
        return buildResponse(() -> clientServices.removePhoneFromClient(clientId, phoneId));
    }
}
