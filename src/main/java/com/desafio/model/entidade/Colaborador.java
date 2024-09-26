package com.desafio.model.entidade;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cargo")
    private String cargo;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    @OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL)
    private Set<Atividade> atividades = new HashSet<>(); // Relacionamento com Atividades

}
