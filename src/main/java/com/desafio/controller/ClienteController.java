package com.desafio.controller;

import com.desafio.model.dto.ClienteDTO;
import com.desafio.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})// Permitir o front-end acessar
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        return new ResponseEntity<>(clienteService.listarClientes(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> cadastrarCliente(@RequestBody ClienteDTO cliente) {
        clienteService.cadastrarCliente(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

}
