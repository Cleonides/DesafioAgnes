package com.desafio.service;

import com.desafio.model.StatusProjeto;
import com.desafio.model.conversor.AtividadeMapper;
import com.desafio.model.dto.AtividadeDTO;
import com.desafio.model.entidade.Atividade;
import com.desafio.model.entidade.Colaborador;
import com.desafio.model.entidade.Projeto;
import com.desafio.repository.AtividadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtividadeService {

    private final AtividadeRepository atividadeRepository;
    private final AtividadeMapper atividadeMapper;
    private final ProjetoService projetoService;
    private final ColaboradorService colaboradorService;

    public AtividadeService(AtividadeRepository atividadeRepository, AtividadeMapper atividadeMapper,
                            ProjetoService projetoService, ColaboradorService colaboradorService) {
        this.atividadeRepository = atividadeRepository;
        this.atividadeMapper = atividadeMapper;
        this.projetoService = projetoService;
        this.colaboradorService = colaboradorService;
    }

    public Atividade cadastrarAtividade(AtividadeDTO atividadeDTO) {
        Atividade atividade = atividadeMapper.toEntidade(atividadeDTO);

        Projeto projeto = projetoService.pesquisarProjetoId(atividadeDTO.getProjeto().getId());
        projeto.setStatus(StatusProjeto.EM_ANDAMENTO);
        projetoService.atualizarProjeto(projeto);

        Colaborador colaborador = colaboradorService.pesquisarColaboradorId(atividadeDTO.getColaborador().getId());
        colaborador.setProjeto(projeto);
        colaboradorService.atualizarColaborador(colaborador);

        atividade.setFinalizada(Boolean.FALSE);
        return atividadeRepository.save(atividade);
    }

    public List<AtividadeDTO> listarAtividades() {
        return atividadeMapper.toDtoList(atividadeRepository.findAll());
    }

    public List<AtividadeDTO> listarAtividadesPorProjeto(Long id) {
        return atividadeMapper.toDtoList(atividadeRepository.findAtividadesByProjetoId(id));
    }
}
