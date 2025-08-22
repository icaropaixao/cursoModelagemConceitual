package com.icaropaixao.cursomodelagem.domain;

import java.io.Serializable;
import java.util.Objects;

public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;

    //construtores
    public Categoria() {}
    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // getters and setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // hashCode and Equals
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
