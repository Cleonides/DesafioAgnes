package com.desafio.service;

import com.desafio.model.conversor.AtividadeMapper;
import com.desafio.model.dto.AtividadeDTO;
import com.desafio.model.entidade.Atividade;
import com.desafio.model.entidade.Colaborador;
import com.desafio.model.entidade.Projeto;
import com.desafio.repository.AtividadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public void cadastrarAtividade(AtividadeDTO atividadeDTO) {
        Atividade atividade = atividadeMapper.toEntidade(atividadeDTO);
        Projeto projeto = projetoService.pesquisarProjetoId(atividadeDTO.getProjetoId());
        Colaborador colaborador = colaboradorService.pesquisarColaboradorId(atividadeDTO.getColaboradorId());
        atividade.setProjeto(projeto);
        atividade.setColaborador(colaborador);
        atividadeRepository.save(atividade);
    }

    public List<AtividadeDTO> listarAtividades() {
        return atividadeMapper.toDtoList(atividadeRepository.findAll());
    }

    public void excluirAtividade(Long idAtividade) {
        Optional<Atividade> atividadeBase = atividadeRepository.findById(idAtividade);
        if (atividadeBase.isPresent()) {
            atividadeRepository.deleteById(idAtividade);
        }
    }
}
