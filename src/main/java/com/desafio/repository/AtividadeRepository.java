package com.desafio.repository;

import com.desafio.model.entidade.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

    @Query("SELECT ativ FROM Atividade ativ WHERE ativ.projeto.id = :id")
    List<Atividade> findAtividadesByProjetoId(@Param("id") Long id);
}