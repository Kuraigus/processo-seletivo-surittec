package com.surittec.springboot.controller;

import com.surittec.springboot.exception.ResourceNotFoundException;
import com.surittec.springboot.model.Client;
import com.surittec.springboot.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    private ClientRepository clienteRepository;

    public ClientController(ClientRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/clientes")
    public List<Client> getAllClientes() {
        return clienteRepository.findAll();
    }

    @PostMapping("/clientes")
    public Client createCliente(@RequestBody Client cliente) {
        return clienteRepository.save(cliente);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Client> getClienteById(@PathVariable(value = "id") long id) throws Exception {
        Client cliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente com id: " + id + " nao encontrado"));
        return ResponseEntity.ok().body(cliente);
    }

    @PutMapping("/clientes")
    public ResponseEntity<Client> updateCliente(@RequestBody Client clienteData) throws Exception {
        clienteRepository.findById(clienteData.getId()).orElseThrow(() -> new ResourceNotFoundException("Cliente com id: " + clienteData.getId() + " nao encontrado"));
        Client clienteAtualizado = clienteRepository.save(clienteData);
        return ResponseEntity.ok().body(clienteAtualizado);
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable(value = "id") long id) throws Exception {
        clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente com id: " + id + " nao encontrado"));

        clienteRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
