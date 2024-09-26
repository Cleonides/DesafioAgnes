package com.desafio.model.dto;

import com.desafio.model.StatusProjeto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProjetoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private StatusProjeto status;
    private Long clienteId;
    private List<AtividadeDTO> atividades;
    private List<ColaboradorDTO> colaboradores;
}
