package com.desafio.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long id;
    private String nome;
    private String descricao;
    private List<ProjetoDTO> projetos;


    public ClienteDTO(String nome, String descricao) {
        this(null, nome, descricao, new ArrayList<>());
    }
}
