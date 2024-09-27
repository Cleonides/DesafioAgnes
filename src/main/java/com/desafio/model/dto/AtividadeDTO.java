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
    private ProjetoDTO projeto;
    private ColaboradorDTO colaborador;
}
