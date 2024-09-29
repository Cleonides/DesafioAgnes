package com.desafio.service;

import com.desafio.model.conversor.ColaboradorMapper;
import com.desafio.model.dto.ColaboradorDTO;
import com.desafio.model.entidade.Colaborador;
import com.desafio.repository.ColaboradorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;
    private final ColaboradorMapper colaboradorMapper;

    public ColaboradorService(ColaboradorRepository colaboradorRepository, ColaboradorMapper colaboradorMapper) {
        this.colaboradorRepository = colaboradorRepository;
        this.colaboradorMapper = colaboradorMapper;
    }

    public Colaborador cadastrarColaborador(ColaboradorDTO colaboradorDTO) {
        return colaboradorRepository.save(colaboradorMapper.toEntidade(colaboradorDTO));
    }

    public List<ColaboradorDTO> listarColaboradores() {
        return colaboradorMapper.toDtoList(colaboradorRepository.findAll());
    }

    public Colaborador pesquisarColaboradorId(Long idProjeto) {
        return colaboradorRepository.findById(idProjeto).get();
    }

    public Colaborador atualizarColaborador(Colaborador colaborador) {
        return colaboradorRepository.save(colaborador);
    }
}
