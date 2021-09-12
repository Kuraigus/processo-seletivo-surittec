package com.surittec.springboot.controller;

import com.surittec.springboot.converters.ClientConverter;
import com.surittec.springboot.dto.ClientDTO;
import com.surittec.springboot.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createClient(@RequestBody final ClientDTO clientDto) {
        return buildResponse(() -> clientServices.addClient(ClientConverter.convertClientDTOToClient(clientDto)));
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getClient() {
        return buildResponse(() -> clientServices.getClients()
                .stream()
                .map(ClientConverter::convertClientToClientDTO)
                .collect(Collectors.toList())
        );
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable final Long id) {
        return buildResponse(() -> clientServices.getClientById(id));
    }

    @DeleteMapping(value = "{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteClientById(@PathVariable final Long id) {
        return buildResponse(() -> clientServices.deleteClient(id));
    }

    @PutMapping(value = "{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ClientDTO> updateClientById(@PathVariable final Long id, @RequestBody final ClientDTO clientDto) {
        return buildResponse(() -> clientServices.updateClient(id, (ClientConverter.convertClientDTOToClient(clientDto))));

    }

    @PostMapping(value = "{clientId}/phones/{phoneId}/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ClientDTO> addPhoneToClient(@PathVariable final Long clientId, @PathVariable final Long phoneId) {
        return buildResponse(() -> clientServices.addPhoneToClient(clientId, phoneId));

    }

    @DeleteMapping(value = "{clientId}/phones/{phoneId}/remove")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ClientDTO> removePhoneFromClient(@PathVariable final Long clientId, @PathVariable final Long phoneId) {
        return buildResponse(() -> clientServices.removePhoneFromClient(clientId, phoneId));
    }

    @PostMapping(value = "{clientId}/email/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ClientDTO> addPhoneToClient(@PathVariable final Long clientId, @RequestBody final String email) {
        return buildResponse(() -> clientServices.addEmailToClient(clientId, email));

    }

    @DeleteMapping(value = "{clientId}/email/remove")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ClientDTO> removeEmailFromClient(@PathVariable final Long clientId, @RequestBody final String email) {
        return buildResponse(() -> clientServices.removeEmailFromClient(clientId, email));
    }
}
