package com.desafio.controller;

import com.desafio.model.dto.ClienteDTO;
import com.desafio.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
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

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Optional<ClienteDTO>> excluirCliente(@PathVariable Long id) {
        try {
            clienteService.excluirCliente(id);
            return new ResponseEntity<Optional<ClienteDTO>>(HttpStatus.OK);
        } catch (NoSuchElementException nsee) {
            return new ResponseEntity<Optional<ClienteDTO>>(HttpStatus.NOT_FOUND);
        }
    }


}
