package com.desafio.controller;

import com.desafio.model.dto.ColaboradorDTO;
import com.desafio.service.ColaboradorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {
    private final ColaboradorService colaboradorService;

    public ColaboradorController(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    @GetMapping
    public ResponseEntity<List<ColaboradorDTO>> listarColaboradores() {
        return new ResponseEntity<>(colaboradorService.listarColaboradores(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ColaboradorDTO> cadastrarColaborador(@RequestBody ColaboradorDTO colaboradorDTO) {
        colaboradorService.cadastrarColaborador(colaboradorDTO);
        return new ResponseEntity<>(colaboradorDTO, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Optional<ColaboradorDTO>> excluirColaborador(@PathVariable Long id) {
        try {
            colaboradorService.excluirColaborador(id);
            return new ResponseEntity<Optional<ColaboradorDTO>>(HttpStatus.OK);
        } catch (NoSuchElementException nsee) {
            return new ResponseEntity<Optional<ColaboradorDTO>>(HttpStatus.NOT_FOUND);
        }
    }
}
