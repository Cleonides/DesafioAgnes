package com.desafio.service;

import com.desafio.model.conversor.ClienteMapper;
import com.desafio.model.dto.ClienteDTO;
import com.desafio.model.entidade.Cliente;
import com.desafio.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public Cliente cadastrarCliente(ClienteDTO clienteDTO) {
        return clienteRepository.save(clienteMapper.toEntidade(clienteDTO));
    }

    public List<ClienteDTO> listarClientes() {
        return clienteMapper.toDtoList(clienteRepository.findAll());
    }

    public Cliente pesquisarClienteId(Long clienteId) {
        return clienteRepository.findById(clienteId).get();
    }

}
