package com.desafio.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long id;
    private String nome;
    private String descricao;


    public ClienteDTO(String nome, String descricao) {
        this(null, nome, descricao);
    }
}
