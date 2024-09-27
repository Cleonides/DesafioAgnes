package com.desafio.model.dto;

import com.desafio.model.StatusProjeto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjetoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private StatusProjeto status;
    private ClienteDTO cliente;
}
