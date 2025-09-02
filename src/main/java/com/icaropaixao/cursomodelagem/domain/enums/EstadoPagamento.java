package com.icaropaixao.cursomodelagem.domain.enums;

import java.io.Serializable;

public enum EstadoPagamento  {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANELADO(3, "Cancelado");

    private int cod;
    private String descricao;

    private EstadoPagamento (int cod, String descricao){
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }
    public String getDescricao() {
        return descricao;
    }


    public static EstadoPagamento toEnum(Integer cod){
        // Verifica se o código é nulo, retornando null se for
        if (cod == null){
            return null;
        }

        // Percorre todos os valores possíveis do enum TipoCliente
        for (EstadoPagamento x : EstadoPagamento.values()){
            // Compara o código recebido com o código do enum e retorna o enum correspondente
            if (cod.equals(x.getCod() )) {
                return x;
            }
        }

        // Lança exceção se nenhum enum corresponder ao código informado
        throw new IllegalArgumentException("Id invalido: " + cod);
    }

}
