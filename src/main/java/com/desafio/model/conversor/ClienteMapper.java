package com.desafio.model.conversor;

import com.desafio.model.dto.ClienteDTO;
import com.desafio.model.entidade.Cliente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteDTO toDto(Cliente cliente);

    Cliente toEntidade(ClienteDTO clienteDTO);

    List<ClienteDTO> toDtoList(List<Cliente> clientes);

    List<Cliente> toEntidadeList(List<ClienteDTO> clientesDtos);
}
