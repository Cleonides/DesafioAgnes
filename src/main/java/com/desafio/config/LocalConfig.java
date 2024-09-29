package com.desafio.config;

import com.desafio.model.entidade.Cliente;
import com.desafio.repository.ClienteRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private ClienteRepository repository;

    @PostConstruct
    public void startDB(){
        Cliente cliente1 = new Cliente(null,"Microsoft", "Multinacional  Empresa de Software", null);
        Cliente cliente2 = new Cliente(null, "Banco Brasil", "Empresa no setor financeiro", null);
        Cliente cliente3 = new Cliente(null, "Bradesco", "Empresa no setor financeiro 2", null);

        repository.saveAll(List.of(cliente1, cliente2, cliente3));

    }
}
