package com.desafio.controller;

import com.desafio.model.dto.AtividadeDTO;
import com.desafio.service.AtividadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/atividade")
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

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Optional<AtividadeDTO>> excluirAtividade(@PathVariable Long id) {
        try {
            atividadeService.excluirAtividade(id);
            return new ResponseEntity<Optional<AtividadeDTO>>(HttpStatus.OK);
        } catch (NoSuchElementException nsee) {
            return new ResponseEntity<Optional<AtividadeDTO>>(HttpStatus.NOT_FOUND);
        }
    }
}
