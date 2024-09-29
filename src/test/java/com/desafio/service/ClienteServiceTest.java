package com.desafio.service;

import com.desafio.model.conversor.ClienteMapper;
import com.desafio.model.dto.ClienteDTO;
import com.desafio.model.entidade.Cliente;
import com.desafio.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class ClienteServiceTest {

    public static final String NOME = "Microsoft";
    public static final String DESCRICAO = "Multinacional  Empresa de Software";
    public static final int INDEX = 0;
    public static final long ID = 1L;
    @Mock
    private  ClienteRepository clienteRepository;
    @Mock
    private  ClienteMapper clienteMapper;
    @InjectMocks
    private ClienteService clienteService;
    private Cliente cliente;
    private ClienteDTO clienteDTO;
    private Optional<Cliente> clienteOptional;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        iniciarCliente();
    }

    @Test
    void listarClientes() {
        when(clienteMapper.toDtoList(clienteRepository.findAll())).thenReturn(List.of(clienteDTO));
        List<ClienteDTO> clientes = clienteService.listarClientes();

        assertNotNull(clientes);
        assertEquals(1, clientes.size());
        assertCamposClienteDTO(clientes.get(INDEX));
    }

    @Test
    void cadastrarCliente() {
        when(clienteRepository.save(clienteMapper.toEntidade(any()))).thenReturn(cliente);
        Cliente cliente = clienteService.cadastrarCliente(clienteDTO);

        assertNotNull(cliente);
        assertCamposCliente(cliente);
    }

    @Test
    void pesquisarClienteId() {
        when(clienteRepository.findById(anyLong())).thenReturn(clienteOptional);

        Cliente cliente = clienteService.pesquisarClienteId(ID);
        assertNotNull(cliente);
        assertCamposCliente(cliente);

    }

    private void iniciarCliente(){
        cliente = new Cliente(ID, NOME, DESCRICAO, null);
        clienteDTO = new ClienteDTO(ID, NOME, DESCRICAO);
        clienteOptional = Optional.of(new Cliente(ID, NOME, DESCRICAO, null));
    }

    private void assertCamposCliente(Cliente cliente){
        assertEquals(ID, cliente.getId());
        assertEquals(NOME, cliente.getNome());
        assertEquals(DESCRICAO, cliente.getDescricao());
        assertEquals(Cliente.class, cliente.getClass());
    }

    private void assertCamposClienteDTO(ClienteDTO clienteDTO){
        assertEquals(ID, clienteDTO.getId());
        assertEquals(NOME, clienteDTO.getNome());
        assertEquals(DESCRICAO, clienteDTO.getDescricao());
        assertEquals(ClienteDTO.class, clienteDTO.getClass());
    }
}