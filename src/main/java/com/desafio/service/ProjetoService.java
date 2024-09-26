package com.desafio.service;

import com.desafio.model.StatusProjeto;
import com.desafio.model.conversor.ProjetoMapper;
import com.desafio.model.dto.ProjetoDTO;
import com.desafio.model.entidade.Cliente;
import com.desafio.model.entidade.Projeto;
import com.desafio.repository.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void cadastrarProjeto(ProjetoDTO projetoDTO) {
        Projeto projeto = projetoMapper.toEntidade(projetoDTO);
        Cliente cliente = clienteService.pesquisarClienteId(projetoDTO.getClienteId());
        projeto.setCliente(cliente);
        projeto.setStatus(StatusProjeto.ABERTO);
        projetoRepository.save(projeto);
    }

    public Projeto pesquisarProjetoId(Long idProjeto) {
        return projetoRepository.findById(idProjeto).get();
    }

    public void atualizarProjeto(Long idProjeto, ProjetoDTO projetoDTO) {
        Projeto projetoTela = projetoMapper.toEntidade(projetoDTO);
        Projeto projetoBase = projetoRepository.findById(idProjeto).get();
        projetoBase.getAtividades().addAll(projetoTela.getAtividades());
        projetoBase.setStatus(StatusProjeto.EM_ANDAMENTO);
        projetoRepository.save(projetoBase);
    }

    public void finalizarProjeto(Long idProjeto, ProjetoDTO projetoDTO) {
        Projeto projetoTela = projetoMapper.toEntidade(projetoDTO);
        Projeto projetoBase = projetoRepository.findById(idProjeto).get();
        boolean todasFinalizadas = projetoTela.getAtividades().stream()
                .allMatch(atividade -> atividade.getFinalizada() == Boolean.TRUE);
        if (todasFinalizadas) {
            projetoBase.getAtividades().addAll(projetoTela.getAtividades());
            projetoBase.setStatus(StatusProjeto.CONCLUIDO);
            projetoRepository.save(projetoBase);
        }
    }

    public List<ProjetoDTO> listarProjetos() {
        return projetoMapper.toDtoList(projetoRepository.findAll());
    }

    public void excluirProjeto(Long idProjeto) {
        Optional<Projeto> projetoBase = projetoRepository.findById(idProjeto);
        if (projetoBase.isPresent()) {
            projetoRepository.deleteById(idProjeto);
        }
    }
}
