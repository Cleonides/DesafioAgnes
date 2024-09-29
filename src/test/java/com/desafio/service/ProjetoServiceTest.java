package com.desafio.service;

import com.desafio.model.StatusProjeto;
import com.desafio.model.conversor.ProjetoMapper;
import com.desafio.model.dto.AtividadeDTO;
import com.desafio.model.dto.ClienteDTO;
import com.desafio.model.dto.ProjetoDTO;
import com.desafio.model.entidade.Atividade;
import com.desafio.model.entidade.Cliente;
import com.desafio.model.entidade.Projeto;
import com.desafio.repository.ProjetoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

class ProjetoServiceTest {

    public static final String NOME_CLIENTE = "Microsoft";
    public static final String DESCRICAO_CLIENTE = "Multinacional  Empresa de Software";
    public static final String NOME_PROJETO = "Sistema de crédito";
    public static final String DESCRICAO_PROJETO = "Sistema responsável pelo setor de pagamentos (débito, crédito, boleto)";
    public static final StatusProjeto STATUS = StatusProjeto.ABERTO;

    public static final int INDEX = 0;
    public static final long ID = 1L;
    @Mock
    private ProjetoRepository projetoRepository;
    @Mock
    private ProjetoMapper projetoMapper;
    @Mock
    private ClienteService clienteService;
    @InjectMocks
    private ProjetoService projetoService;

    private Cliente cliente;
    private ClienteDTO clienteDTO;
    private Projeto projeto;
    private ProjetoDTO projetoDTO;
    private Optional<Projeto> projetoOptional;
    private Atividade atividade;
    private AtividadeDTO atividadeDTO;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        iniciarProjeto();
    }
    @Test
    void cadastrarProjeto() {
        when(projetoMapper.toEntidade(any())).thenReturn(projeto);
        when(clienteService.pesquisarClienteId(anyLong())).thenReturn(cliente);
        when(projetoRepository.save(any())).thenReturn(projeto);
        Projeto projeto1 = projetoService.cadastrarProjeto(projetoDTO);

        assertNotNull(projeto1);
        assertCamposProjeto(projeto1);
    }

    @Test
    void pesquisarProjetoId() {
        when(projetoRepository.findById(anyLong())).thenReturn(projetoOptional);

        Projeto projeto1 = projetoService.pesquisarProjetoId(ID);
        assertNotNull(projeto1);
        assertCamposProjeto(projeto1);

    }

    @Test
    void atualizarProjeto() {
        when(projetoRepository.save(any())).thenReturn(projeto);
        Projeto projeto1 = projetoService.atualizarProjeto(projeto);

        assertNotNull(projeto1);
        assertCamposProjeto(projeto1);
    }

    @Test
    void listarProjetos() {
        when(projetoMapper.toDtoList(projetoRepository.findAll())).thenReturn(List.of(projetoDTO));
        List<ProjetoDTO> projetoDTOS = projetoService.listarProjetos();

        assertNotNull(projetoDTOS);
        assertEquals(1, projetoDTOS.size());
        assertCamposProjetoDTO(projetoDTOS.get(INDEX));
    }

    @Test
    void listarProjetosPorCliente() {
        when(projetoMapper.toDtoList(projetoRepository.findProjetosByClienteId(anyLong()))).thenReturn(List.of(projetoDTO));
        List<ProjetoDTO> projetoDTOS = projetoService.listarProjetosPorCliente(ID);

        assertNotNull(projetoDTOS);
        assertEquals(1, projetoDTOS.size());
        assertCamposProjetoDTO(projetoDTOS.get(INDEX));
    }

    private void iniciarProjeto() {
        cliente = new Cliente(ID, NOME_CLIENTE, DESCRICAO_CLIENTE, null);
        clienteDTO = new ClienteDTO(ID, NOME_CLIENTE, DESCRICAO_CLIENTE);
        Optional<Cliente> vclienteOptional = Optional.of(new Cliente(ID, NOME_CLIENTE, DESCRICAO_CLIENTE, null));

        atividade = new Atividade(ID, "Requesitos e doc", "Criação de requesitos, protótipos e documentação", Boolean.TRUE, null, null);
        atividadeDTO = new AtividadeDTO(ID, "Requesitos e doc", "Criação de requesitos, protótipos e documentação", Boolean.TRUE, null, null);

        projeto = new Projeto(ID, NOME_PROJETO, DESCRICAO_PROJETO, STATUS, cliente, Set.of(atividade), null);
        projetoDTO = new ProjetoDTO(ID, NOME_PROJETO, DESCRICAO_PROJETO, STATUS, clienteDTO);
        projetoOptional = Optional.of(new Projeto(ID, NOME_PROJETO, DESCRICAO_PROJETO, STATUS, cliente, Set.of(atividade), null));
    }

    private void assertCamposProjeto(Projeto projeto) {
        assertEquals(ID, projeto.getId());
        assertEquals(NOME_PROJETO, projeto.getNome());
        assertEquals(DESCRICAO_PROJETO, projeto.getDescricao());
        assertEquals(Projeto.class, projeto.getClass());

        Cliente clienteProjeto = projeto.getCliente();
        assertEquals(ID, clienteProjeto.getId());
        assertEquals(NOME_CLIENTE, clienteProjeto.getNome());
        assertEquals(DESCRICAO_CLIENTE, clienteProjeto.getDescricao());
        assertEquals(Cliente.class, clienteProjeto.getClass());

    }

    private void assertCamposProjetoDTO(ProjetoDTO projetoDTO) {
        assertEquals(ID, projetoDTO.getId());
        assertEquals(NOME_PROJETO, projetoDTO.getNome());
        assertEquals(DESCRICAO_PROJETO, projetoDTO.getDescricao());
        assertEquals(STATUS, projetoDTO.getStatus());
        assertEquals(Projeto.class, projeto.getClass());

        ClienteDTO clienteProjetoDTO = projetoDTO.getCliente();
        assertEquals(ID, clienteProjetoDTO.getId());
        assertEquals(NOME_CLIENTE, clienteProjetoDTO.getNome());
        assertEquals(DESCRICAO_CLIENTE, clienteProjetoDTO.getDescricao());
        assertEquals(ClienteDTO.class, clienteProjetoDTO.getClass());

    }

}