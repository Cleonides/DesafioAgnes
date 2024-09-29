package com.desafio.service;

import com.desafio.model.StatusProjeto;
import com.desafio.model.conversor.ProjetoMapper;
import com.desafio.model.dto.ProjetoDTO;
import com.desafio.model.entidade.Cliente;
import com.desafio.model.entidade.Projeto;
import com.desafio.repository.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    private final ProjetoRepository projetoRepository;
    private final ProjetoMapper projetoMapper;
    private final ClienteService clienteService;

    public ProjetoService(ProjetoRepository projetoRepository, ProjetoMapper projetoMapper, ClienteService clienteService) {
        this.projetoRepository = projetoRepository;
        this.projetoMapper = projetoMapper;
        this.clienteService = clienteService;
    }

    public Projeto cadastrarProjeto(ProjetoDTO projetoDTO) {
        Projeto projeto = projetoMapper.toEntidade(projetoDTO);
        Cliente cliente = clienteService.pesquisarClienteId(projeto.getCliente().getId());
        projeto.setCliente(cliente);
        projeto.setStatus(StatusProjeto.ABERTO);
        return projetoRepository.save(projeto);
    }

    public Projeto pesquisarProjetoId(Long idProjeto) {
        return projetoRepository.findById(idProjeto).get();
    }

    public Projeto atualizarProjeto(Projeto projeto) {
       return projetoRepository.save(projeto);
    }

    public List<ProjetoDTO> listarProjetos() {
        return projetoMapper.toDtoList(projetoRepository.findAll());
    }

    public List<ProjetoDTO> listarProjetosPorCliente(Long id) {
        return projetoMapper.toDtoList(projetoRepository.findProjetosByClienteId(id));
    }

}
