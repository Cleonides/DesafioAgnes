package com.desafio.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtividadeDTO {
    private Long id;
    private String nome;
    private String descricao;
    private Boolean finalizada;
    private Long projetoId;
    private Long colaboradorId;
}
