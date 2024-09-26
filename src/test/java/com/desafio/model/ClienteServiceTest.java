//package com.desafio.model;
//
//import com.desafio.model.dto.ClienteDTO;
//import com.desafio.model.entidade.Cliente;
//import com.desafio.repository.ClienteRepository;
//import com.desafio.service.ClienteService;
//import org.junit.Assert;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@ExtendWith(MockitoExtension.class)
//public class ClienteServiceTest {
//
//    @Mock
//    private ClienteService clienteService;
//
//    @InjectMocks
//    private ClienteRepository clienteRepository;
//
//    @BeforeEach
//    public void setUp() {
//        // Configuração antes de cada teste, se necessário
//    }
//
//    @Test
//    public void testInserirCliente() {
//        // Arrange: Configura o comportamento do mock
//        List<Cliente> clientes = new ArrayList<>();
//        clientes.add(new Cliente(1L, "Produto 1", "10.0", null));
//        clientes.add(new Cliente(2L, "Produto 2", "20.0", null));
//
//        // Configurando o comportamento simulado do produtoRepository
//        Mockito.when(clienteRepository.findAll()).thenReturn(clientes);
//
//        // Chamada do endpoint
//        List<ClienteDTO> result = clienteService.listarClientes();
//
//        // Verificando se todos os produtos foram retornados corretamente
//        Assert.assertEquals(clientes.size(), result.size());
//        Assert.assertEquals(clientes.get(0), result.get(0));
//        Assert.assertEquals(clientes.get(1), result.get(1));
//    }
//
//}
