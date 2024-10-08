package com.desafio.model.conversor;

import com.desafio.model.dto.ColaboradorDTO;
import com.desafio.model.entidade.Colaborador;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ColaboradorMapper {

    @Mapping(target = "projeto", source = "colaborador.projeto")
    ColaboradorDTO toDto(Colaborador colaborador);

    @Mapping(target = "projeto", source = "projeto")
    Colaborador toEntidade(ColaboradorDTO colaboradorDTO);

    List<ColaboradorDTO> toDtoList(List<Colaborador> colaboradores);

    List<Colaborador> toEntidadeList(List<ColaboradorDTO> colaboradorDtos);
}
