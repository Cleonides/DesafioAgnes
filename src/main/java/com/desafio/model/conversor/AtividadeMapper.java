package com.desafio.model.conversor;

import com.desafio.model.dto.AtividadeDTO;
import com.desafio.model.entidade.Atividade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AtividadeMapper {

    @Mapping(source = "projeto.id", target = "projetoId")
    @Mapping(source = "colaborador.id", target = "colaboradorId")
    AtividadeDTO toDto(Atividade atividade);

    @Mapping(source = "projetoId", target = "projeto.id")
    @Mapping(source = "colaboradorId", target = "colaborador.id")
    Atividade toEntidade(AtividadeDTO atividadeDTO);

    List<AtividadeDTO> toDtoList(List<Atividade> atividades);

    List<Atividade> toEntidadeList(List<AtividadeDTO> atividadeDtos);
}
