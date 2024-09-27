package com.desafio.service;

import com.desafio.model.conversor.ColaboradorMapper;
import com.desafio.model.dto.ColaboradorDTO;
import com.desafio.model.entidade.Colaborador;
import com.desafio.repository.ColaboradorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;
    private final ColaboradorMapper colaboradorMapper;

    public ColaboradorService(ColaboradorRepository colaboradorRepository, ColaboradorMapper colaboradorMapper) {
        this.colaboradorRepository = colaboradorRepository;
        this.colaboradorMapper = colaboradorMapper;
    }

    public void cadastrarColaborador(ColaboradorDTO colaboradorDTO) {
        Colaborador colaborador = colaboradorMapper.toEntidade(colaboradorDTO);
        colaboradorRepository.save(colaborador);
    }

    public List<ColaboradorDTO> listarColaboradores() {
        return colaboradorMapper.toDtoList(colaboradorRepository.findAll());
    }

    public Colaborador pesquisarColaboradorId(Long idProjeto) {
        return colaboradorRepository.findById(idProjeto).get();
    }

    public void excluirColaborador(Long idColaborador) {
        Optional<Colaborador> colaboradorBase = colaboradorRepository.findById(idColaborador);
        if (colaboradorBase.isPresent()) {
            colaboradorRepository.deleteById(idColaborador);
        }
    }

    public void atualizarColaborador(Colaborador colaborador) {
        colaboradorRepository.save(colaborador);
    }
}
