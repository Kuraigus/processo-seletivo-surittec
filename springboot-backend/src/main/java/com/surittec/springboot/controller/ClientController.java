package com.surittec.springboot.controller;

import com.surittec.springboot.model.dto.ClientDto;
import com.surittec.springboot.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    private final ClientServices clientServices;

    @Autowired
    public ClientController(ClientServices clientServices) {
        this.clientServices = clientServices;
    }

    @PostMapping
    public ResponseEntity<ClientDto> createClient(@RequestBody final ClientDto clientDTO) {

    }

}
