package com.icaropaixao.cursomodelagem.domain.enums;


public enum TipoCliente {

    PESSOA_FISICA(1,"Pessoa Física"),
    PESSOA_JURIDICA(2, "Pessoa Jurídica");

    private int cod;
    private String descricao;

    private TipoCliente (int cod, String descricao){
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }
    public String getDescricao() {
        return descricao;
    }


    public static TipoCliente toEnum(Integer cod){
        // Verifica se o código é nulo, retornando null se for
        if (cod == null){
            return null;
        }

        // Percorre todos os valores possíveis do enum TipoCliente
        for (TipoCliente x : TipoCliente.values()){
            // Compara o código recebido com o código do enum e retorna o enum correspondente
            if (cod.equals(x.getCod() )) {
                return x;
            }
        }

        // Lança exceção se nenhum enum corresponder ao código informado
        throw new IllegalArgumentException("Id invalido: " + cod);
    }
}
