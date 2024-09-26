package com.desafio.controller;

import com.desafio.model.dto.ProjetoDTO;
import com.desafio.model.entidade.Projeto;
import com.desafio.service.ProjetoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/projeto")
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

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<ProjetoDTO> atualizarProjeto(@PathVariable Long id, @RequestBody ProjetoDTO projetoDTO) {
        projetoService.atualizarProjeto(id, projetoDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/finalizar/{id}")
    public ResponseEntity<Projeto> finalizarProjeto(@PathVariable Long id, @RequestBody ProjetoDTO projetoDTO) {
        projetoService.finalizarProjeto(id, projetoDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Optional<ProjetoDTO>> excluirProjeto(@PathVariable Long id) {
        try {
            projetoService.excluirProjeto(id);
            return new ResponseEntity<Optional<ProjetoDTO>>(HttpStatus.OK);
        } catch (NoSuchElementException nsee) {
            return new ResponseEntity<Optional<ProjetoDTO>>(HttpStatus.NOT_FOUND);
        }
    }
}
