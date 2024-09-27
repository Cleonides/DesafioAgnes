package com.desafio.model.conversor;

import com.desafio.model.dto.ProjetoDTO;
import com.desafio.model.entidade.Projeto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjetoMapper {

    @Mapping(target = "cliente", source = "projeto.cliente")
    ProjetoDTO toDto(Projeto projeto);

    @Mapping(target = "cliente", source = "cliente")
    Projeto toEntidade(ProjetoDTO projetoDTO);

    List<ProjetoDTO> toDtoList(List<Projeto> projetos);

    List<Projeto> toEntidadeList(List<ProjetoDTO> projetoDtos);
}
