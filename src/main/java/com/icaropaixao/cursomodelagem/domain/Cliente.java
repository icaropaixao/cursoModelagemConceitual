package com.icaropaixao.cursomodelagem.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.icaropaixao.cursomodelagem.domain.enums.TipoCliente;
import jakarta.persistence.*;
import org.springframework.orm.jpa.persistenceunit.SmartPersistenceUnitInfo;

import java.io.Serializable;
import java.util.*;

@Entity
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String email;
    private String cpfOuCnpj;

    private Integer tipo;

    @JsonManagedReference
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();

    // conjunto de strings que não aceita repetições de dados iguais
    @ElementCollection
    @CollectionTable(name = "TELEFONE")
    private Set<String> telefones = new HashSet<>();

    @OneToMany
    private List<Pedido> pedidos = new ArrayList<>();

    // constructors
    public Cliente() {}

    public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipo = tipo.getCod();

    }

    // getters and setters


    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    // Metodo que retorna o tipo do cliente como enum TipoCliente
    public TipoCliente getTipo() {
        // Converte o valor inteiro 'tipo' armazenado no banco em um enum TipoCliente
        return TipoCliente.toEnum(tipo);
    }

    // Metodo que define o tipo do cliente
    public void setTipo(TipoCliente tipo) {
        // Armazena no atributo 'tipo' o código inteiro correspondente ao enum recebido
        this.tipo = tipo.getCod();
    }


    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Set<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<String> telefones) {
        this.telefones = telefones;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
