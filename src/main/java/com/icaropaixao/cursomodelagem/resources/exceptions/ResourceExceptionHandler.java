package com.icaropaixao.cursomodelagem.resources.exceptions;


import com.icaropaixao.cursomodelagem.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Anotação que intercepta exceções lançadas pelos controladores (controllers)
@ControllerAdvice
public class ResourceExceptionHandler { // Classe responsável por tratar exceções globais da aplicação

    // Define que este metodo vai tratar a exceção ObjectNotFoundException
    @ExceptionHandler(ObjectNotFoundException.class)

    // Metodo que monta a resposta HTTP personalizada quando a exceção é lançada
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request) {

        // Cria um objeto de erro contendo código, mensagem e timestamp
        StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis());

        // Retorna a resposta HTTP 404 com o corpo de erro
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }
}

