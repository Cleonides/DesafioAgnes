package com.desafio.model.conversor;

import com.desafio.model.dto.AtividadeDTO;
import com.desafio.model.entidade.Atividade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AtividadeMapper {

    @Mapping(target = "projeto", source = "atividade.projeto")
    @Mapping(target = "colaborador", source = "atividade.colaborador")
    AtividadeDTO toDto(Atividade atividade);

    @Mapping(target = "projeto", source = "projeto")
    @Mapping(target = "colaborador", source = "colaborador")
    Atividade toEntidade(AtividadeDTO atividadeDTO);

    List<AtividadeDTO> toDtoList(List<Atividade> atividades);

    List<Atividade> toEntidadeList(List<AtividadeDTO> atividadeDtos);
}
