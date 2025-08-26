package com.icaropaixao.cursomodelagem;

import com.icaropaixao.cursomodelagem.domain.Categoria;
import com.icaropaixao.cursomodelagem.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursoModelagemApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public static void main(String[] args) {
        SpringApplication.run(CursoModelagemApplication.class, args);
    }

    // executa quando roda a aplicação
    // salvando dados no banco
    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null,"Informática");
        Categoria cat2 = new Categoria(null,"Escritório");

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));


    }





}
