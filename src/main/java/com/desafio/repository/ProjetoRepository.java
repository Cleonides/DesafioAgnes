package com.desafio.repository;

import com.desafio.model.entidade.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

    @Query("SELECT proj FROM Projeto proj WHERE proj.cliente.id = :id")
    List<Projeto> findProjetosByClienteId(@Param("id") Long id);

}