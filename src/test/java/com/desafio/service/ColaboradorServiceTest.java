package com.desafio.service;

import com.desafio.model.conversor.ColaboradorMapper;
import com.desafio.model.dto.ColaboradorDTO;
import com.desafio.model.entidade.Colaborador;
import com.desafio.repository.ColaboradorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class ColaboradorServiceTest {
    public static final String NOME = "Carlos";
    public static final String CARGO = "'Desenvolvedor'";
    public static final int INDEX = 0;
    public static final long ID = 1L;
    @Mock
    private ColaboradorRepository colaboradorRepository;
    @Mock
    private ColaboradorMapper colaboradorMapper;
    @InjectMocks
    private ColaboradorService colaboradorService;
    private Colaborador colaborador;
    private ColaboradorDTO colaboradorDTO;
    private Optional<Colaborador> colaboradorOptional;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        iniciarColaborador();
    }
    @Test
    void cadastrarColaborador() {
        when(colaboradorRepository.save(colaboradorMapper.toEntidade(any()))).thenReturn(colaborador);

        Colaborador colaborador = colaboradorService.cadastrarColaborador(colaboradorDTO);

        assertNotNull(colaborador);
        assertCamposColaborador(colaborador);
    }

    @Test
    void listarColaboradores() {
        when(colaboradorMapper.toDtoList(colaboradorRepository.findAll())).thenReturn(List.of(colaboradorDTO));

        List<ColaboradorDTO> colaboradores = colaboradorService.listarColaboradores();

        assertNotNull(colaboradores);
        assertEquals(1, colaboradores.size());
        assertCamposColaboradorDTO(colaboradores.get(INDEX));
    }

    @Test
    void pesquisarColaboradorId() {
        when(colaboradorRepository.findById(anyLong())).thenReturn(colaboradorOptional);

        Colaborador colaborador1 = colaboradorService.pesquisarColaboradorId(ID);
        assertNotNull(colaborador1);
        assertCamposColaborador(colaborador1);
    }

    @Test
    void atualizarColaborador() {
        when(colaboradorRepository.save(any())).thenReturn(colaborador);

        Colaborador colaborador1 = colaboradorService.atualizarColaborador(colaborador);

        assertNotNull(colaborador1);
        assertCamposColaborador(colaborador1);
    }

    private void iniciarColaborador(){
        colaborador = new Colaborador(ID, NOME, CARGO, null, null);
        colaboradorDTO = new ColaboradorDTO(ID, NOME, CARGO, null);
        colaboradorOptional = Optional.of(new Colaborador(ID, NOME, CARGO, null, null));
    }

    private void assertCamposColaborador(Colaborador colaborador){
        assertEquals(ID, colaborador.getId());
        assertEquals(NOME, colaborador.getNome());
        assertEquals(CARGO, colaborador.getCargo());
        assertEquals(Colaborador.class, colaborador.getClass());
    }

    private void assertCamposColaboradorDTO(ColaboradorDTO colaboradorDTO){
        assertEquals(ID, colaboradorDTO.getId());
        assertEquals(NOME, colaboradorDTO.getNome());
        assertEquals(CARGO, colaboradorDTO.getCargo());
        assertEquals(ColaboradorDTO.class, colaboradorDTO.getClass());
    }
}