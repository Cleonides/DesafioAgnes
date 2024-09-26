package com.desafio.model.conversor;

import com.desafio.model.dto.ColaboradorDTO;
import com.desafio.model.entidade.Colaborador;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ColaboradorMapper {

    ColaboradorDTO toDto(Colaborador colaborador);

    Colaborador toEntidade(ColaboradorDTO colaboradorDTO);

    List<ColaboradorDTO> toDtoList(List<Colaborador> colaboradores);

    List<Colaborador> toEntidadeList(List<ColaboradorDTO> colaboradorDtos);
}
