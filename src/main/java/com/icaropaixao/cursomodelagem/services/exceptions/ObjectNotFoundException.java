package com.icaropaixao.cursomodelagem.services.exceptions;


// Cria uma exceção personalizada que herda de RuntimeException
public class ObjectNotFoundException extends RuntimeException {

    // Identificador de versão da classe para serialização
    private static final long serialVersionUID = 1L;


    // Construtor que recebe apenas a mensagem de erro
    public ObjectNotFoundException(String message) {
        super(message);

    }

    // Construtor que recebe mensagem e a causa do erro
    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);

    }

}
