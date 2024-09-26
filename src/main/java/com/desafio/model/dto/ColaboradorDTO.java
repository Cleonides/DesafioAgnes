package com.desafio.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ColaboradorDTO {

    private Long id;
    private String nome;
    private String cargo;
    private Long projetoId;
    private List<AtividadeDTO> atividades; // Relacionamento com Atividades
}
