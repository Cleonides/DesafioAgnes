package com.desafio.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AtividadeDTO {
    
    private Long id;
    private String nome;
    private String descricao;
    private Boolean finalizada;
    private ProjetoDTO projeto;
    private ColaboradorDTO colaborador;
}
