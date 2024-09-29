package com.desafio.model.entidade;

import com.desafio.model.StatusProjeto;
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
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "status")
    private StatusProjeto status;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL)
    private Set<Atividade> atividades = new HashSet<>();

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL)
    private Set<Colaborador> colaboradores = new HashSet<>();

}
