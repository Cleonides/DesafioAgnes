package com.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//**Em andamento**
//TODO CENÁRIO DE TESTES DE ATIVIDADE
//TODO cria o nome do relacionamento correto fizemos na atividade para colaborador falta o restante
//TODO colocar o mapper para rodar e usar os dtos nos controller.
//TODO fazer um insert de cada campo
//TODO Criar cenários de testes para todos as tabelas.

//**Concluído**
//TODO criar o excluir cliente só para ficar mais fácil. OK
//TODO criar o excluir colaborador só para ficar mais fácil. OK
//TODO criar o excluir produto só para ficar mais fácil. OK
//TODO criar o excluir atividade só para ficar mais fácil. OK
//TODO CENÁRIO DE TESTES DE CLIENTE - OK ENDPOINT
//TODO CENÁRIO DE TESTES DE COLABORADOR - OK ENDPOINT
//TODO CENÁRIO DE TESTES DE CLIENTE - OK ENDPOINT


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
