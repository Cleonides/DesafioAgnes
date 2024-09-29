package com.desafio.service;

import com.desafio.model.StatusProjeto;
import com.desafio.model.conversor.AtividadeMapper;
import com.desafio.model.dto.AtividadeDTO;
import com.desafio.model.dto.ClienteDTO;
import com.desafio.model.dto.ColaboradorDTO;
import com.desafio.model.dto.ProjetoDTO;
import com.desafio.model.entidade.Atividade;
import com.desafio.model.entidade.Cliente;
import com.desafio.model.entidade.Colaborador;
import com.desafio.model.entidade.Projeto;
import com.desafio.repository.AtividadeRepository;
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

class AtividadeServiceTest {

    public static final String NOME_CLIENTE = "Microsoft";
    public static final String DESCRICAO_CLIENTE = "Multinacional  Empresa de Software";
    public static final String NOME_COLABORADOR = "Carlos";
    public static final String CARGO_COLABORADOR = "'Desenvolvedor'";
    public static final String NOME_PROJETO = "Sistema de crédito";
    public static final String DESCRICAO_PROJETO = "Sistema responsável pelo setor de pagamentos (débito, crédito, boleto)";
    public static final StatusProjeto STATUS = StatusProjeto.ABERTO;
    public static final int INDEX = 0;
    public static final long ID = 1L;
    public static final String NOME_ATIVIDADE = "Requesitos e doc";
    public static final String DESCRICAO_ATIVIDADE = "Criação de requesitos, protótipos e documentação";
    @Mock
    private AtividadeRepository atividadeRepository;
    @Mock
    private AtividadeMapper atividadeMapper;
    @Mock
    private ProjetoService projetoService;
    @Mock
    private ColaboradorService colaboradorService;
    @InjectMocks
    private AtividadeService atividadeService;
    private Atividade atividade;
    private AtividadeDTO atividadeDTO;
    private Optional<Atividade> atividadeOptional;
    private Colaborador colaborador;
    private Projeto projeto;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        iniciarCliente();
    }


    @Test
    void cadastrarAtividade() {
        when(atividadeMapper.toEntidade(any())).thenReturn(atividade);
        when(projetoService.pesquisarProjetoId(anyLong())).thenReturn(projeto);
        when(colaboradorService.pesquisarColaboradorId(anyLong())).thenReturn(colaborador);
        atividade.setFinalizada(Boolean.TRUE);
        when(atividadeRepository.save(any())).thenReturn(atividade);

        Atividade atividade1 = atividadeService.cadastrarAtividade(atividadeDTO);
        assertNotNull(atividade1);
        assertCamposAtividade(atividade1);
    }

    @Test
    void listarAtividades() {
        when(atividadeMapper.toDtoList(atividadeRepository.findAll())).thenReturn(List.of(atividadeDTO));
        List<AtividadeDTO> atividades = atividadeService.listarAtividades();

        assertNotNull(atividades);
        assertEquals(1, atividades.size());
        assertCamposAtividadeDTO(atividades.get(INDEX));
    }

    @Test
    void listarAtividadesPorProjeto() {
        when(atividadeMapper.toDtoList(atividadeRepository.findAtividadesByProjetoId(anyLong()))).thenReturn(List.of(atividadeDTO));

        List<AtividadeDTO> atividades = atividadeService.listarAtividadesPorProjeto(ID);
        assertNotNull(atividades);
        assertEquals(1, atividades.size());
        assertCamposAtividadeDTO(atividades.get(INDEX));

    }


    private void iniciarCliente(){

        Cliente cliente = new Cliente(ID, NOME_CLIENTE, DESCRICAO_CLIENTE, null);
        ClienteDTO clienteDTO = new ClienteDTO(ID, NOME_CLIENTE, DESCRICAO_CLIENTE);

        colaborador = new Colaborador(ID, NOME_COLABORADOR, CARGO_COLABORADOR, null, null);
        ColaboradorDTO colaboradorDTO = new ColaboradorDTO(ID, NOME_COLABORADOR, CARGO_COLABORADOR, null);

        projeto = new Projeto(ID, NOME_PROJETO, DESCRICAO_PROJETO, STATUS, cliente, null, null);
        ProjetoDTO projetoDTO = new ProjetoDTO(ID, NOME_PROJETO, DESCRICAO_PROJETO, STATUS, clienteDTO);

        atividade = new Atividade(ID, NOME_ATIVIDADE, DESCRICAO_ATIVIDADE, Boolean.TRUE, projeto, colaborador);
        atividadeDTO = new AtividadeDTO(ID, NOME_ATIVIDADE, DESCRICAO_ATIVIDADE, Boolean.TRUE, projetoDTO, colaboradorDTO);
    }


    private void assertCamposAtividade(Atividade atividade){
        assertEquals(ID, atividade.getId());
        assertEquals(NOME_ATIVIDADE, atividade.getNome());
        assertEquals(DESCRICAO_ATIVIDADE, atividade.getDescricao());
        assertEquals(Boolean.FALSE, atividade.getFinalizada());
        assertEquals(Atividade.class, atividade.getClass());

        Projeto projetoAtividade = atividade.getProjeto();
        assertEquals(ID, projetoAtividade.getId());
        assertEquals(NOME_PROJETO, projetoAtividade.getNome());
        assertEquals(DESCRICAO_PROJETO, projetoAtividade.getDescricao());
        assertEquals(Projeto.class, projetoAtividade.getClass());

        Cliente clienteProjeto = projeto.getCliente();
        assertEquals(ID, clienteProjeto.getId());
        assertEquals(NOME_CLIENTE, clienteProjeto.getNome());
        assertEquals(DESCRICAO_CLIENTE, clienteProjeto.getDescricao());
        assertEquals(Cliente.class, clienteProjeto.getClass());

        Colaborador colaboradorAtividade = atividade.getColaborador();
        assertEquals(ID, colaboradorAtividade.getId());
        assertEquals(NOME_COLABORADOR, colaboradorAtividade.getNome());
        assertEquals(CARGO_COLABORADOR, colaboradorAtividade.getCargo());
        assertEquals(Colaborador.class, colaboradorAtividade.getClass());
    }

    private void assertCamposAtividadeDTO(AtividadeDTO atividadeDTO){
        assertEquals(ID, atividadeDTO.getId());
        assertEquals(NOME_ATIVIDADE, atividadeDTO.getNome());
        assertEquals(DESCRICAO_ATIVIDADE, atividadeDTO.getDescricao());
        assertEquals(AtividadeDTO.class, atividadeDTO.getClass());

        ProjetoDTO projetoAtividadeDTO = atividadeDTO.getProjeto();
        assertEquals(ID, projetoAtividadeDTO.getId());
        assertEquals(NOME_PROJETO, projetoAtividadeDTO.getNome());
        assertEquals(DESCRICAO_PROJETO, projetoAtividadeDTO.getDescricao());
        assertEquals(ProjetoDTO.class, projetoAtividadeDTO.getClass());

        ClienteDTO clienteProjetoDTO = projetoAtividadeDTO.getCliente();
        assertEquals(ID, clienteProjetoDTO.getId());
        assertEquals(NOME_CLIENTE, clienteProjetoDTO.getNome());
        assertEquals(DESCRICAO_CLIENTE, clienteProjetoDTO.getDescricao());
        assertEquals(ClienteDTO.class, clienteProjetoDTO.getClass());

        ColaboradorDTO colaboradorAtividadeDTO = atividadeDTO.getColaborador();
        assertEquals(ID, colaboradorAtividadeDTO.getId());
        assertEquals(NOME_COLABORADOR, colaboradorAtividadeDTO.getNome());
        assertEquals(CARGO_COLABORADOR, colaboradorAtividadeDTO.getCargo());
        assertEquals(ColaboradorDTO.class, colaboradorAtividadeDTO.getClass());
    }
}