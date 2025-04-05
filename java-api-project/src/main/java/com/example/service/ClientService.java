package com.example.service;

import com.example.model.Client;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClientService {

    private Map<Long, Client> clientRepository = new HashMap<>();

    public ClientService() {
        // Inicializar algunos datos de ejemplo
        clientRepository.put(1L, new Client(1L, "Juan Pérez", "juan.perez@example.com"));
        clientRepository.put(2L, new Client(2L, "Ana Gómez", "ana.gomez@example.com"));
    }

    public Client findClientById(Long id) {
        return clientRepository.get(id);
    }
}