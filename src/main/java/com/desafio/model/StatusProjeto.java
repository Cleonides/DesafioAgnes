package com.desafio.model;

public enum StatusProjeto {
    ABERTO(0),
    EM_ANDAMENTO(1),
    CONCLUIDO(2);

    private final int valor;

    StatusProjeto(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static StatusProjeto fromValor(int valor) {
        for (StatusProjeto status : StatusProjeto.values()) {
            if (status.getValor() == valor) {
                return status;
            }
        }
        throw new IllegalArgumentException("Valor inválido: " + valor);
    }
}
