package com.example.controller;

import com.example.model.Client;
import com.example.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients/{id}")
    public Client getClient(@PathVariable Long id) {
        return clientService.findClientById(id);
    }
}