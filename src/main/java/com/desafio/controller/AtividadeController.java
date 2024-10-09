package com.desafio.controller;

import com.desafio.model.dto.AtividadeDTO;
import com.desafio.service.AtividadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atividade")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"}) // Permitir o front-end acessar
public class AtividadeController {
    private final AtividadeService atividadeService;

    public AtividadeController(AtividadeService atividadeService) {
        this.atividadeService = atividadeService;
    }

    @GetMapping
    public ResponseEntity<List<AtividadeDTO>> listarAtividades() {
        return new ResponseEntity<>(atividadeService.listarAtividades(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AtividadeDTO> cadastrarAtividade(@RequestBody AtividadeDTO atividade) {
        atividadeService.cadastrarAtividade(atividade);
        return new ResponseEntity<>(atividade, HttpStatus.OK);
    }

    @GetMapping("/projeto/{id}")
    public ResponseEntity<List<AtividadeDTO>> listarAtividadesPorProjeto(@PathVariable Long id) {
        return new ResponseEntity<>(atividadeService.listarAtividadesPorProjeto(id), HttpStatus.OK);
    }

}
