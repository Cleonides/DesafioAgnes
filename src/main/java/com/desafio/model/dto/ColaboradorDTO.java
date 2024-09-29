package com.desafio.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ColaboradorDTO {

    private Long id;
    private String nome;
    private String cargo;
    private ProjetoDTO projeto;
}
