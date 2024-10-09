package com.desafio.controller;

import com.desafio.model.dto.ProjetoDTO;
import com.desafio.service.ProjetoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projeto")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"}) // Permitir o front-end acessar
public class ProjetoController {
    private final ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @GetMapping
    public ResponseEntity<List<ProjetoDTO>> listarProjetos() {
        return new ResponseEntity<>(projetoService.listarProjetos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProjetoDTO> cadastrarProjeto(@RequestBody ProjetoDTO projetoDTO) {
        projetoService.cadastrarProjeto(projetoDTO);
        return new ResponseEntity<>(projetoDTO, HttpStatus.OK);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<ProjetoDTO>> listarProjetosPorCliente(@PathVariable Long id) {
        return new ResponseEntity<>(projetoService.listarProjetosPorCliente(id), HttpStatus.OK);
    }

}
