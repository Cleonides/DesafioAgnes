package com.desafio.controller;

import com.desafio.model.dto.ColaboradorDTO;
import com.desafio.service.ColaboradorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colaborador")
@CrossOrigin(origins = "http://localhost:8080") // Permitir o front-end acessar
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

}
