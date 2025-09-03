package com.icaropaixao.cursomodelagem.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable // Indica que essa classe será usada como chave composta em outra entidade
public class ItemPedidoPK implements Serializable {
    private static final long serialVersionUID = 1L;

    // Muitos itens podem pertencer a um mesmo pedido (relação N:1)
    @ManyToOne
    @JoinColumn(name = "pedido_id") // Cria a coluna "pedido_id" como chave estrangeira para Pedido
    private Pedido pedido;

    // Muitos itens podem se referir ao mesmo produto (relação N:1)
    @ManyToOne
    @JoinColumn(name = "produto_id") // Cria a coluna "produto_id" como chave estrangeira para Produto
    private Produto produto;


    public Pedido getPedido() {
        return pedido;
    }
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedidoPK that = (ItemPedidoPK) o;
        return Objects.equals(pedido, that.pedido) && Objects.equals(produto, that.produto);
    }
    @Override
    public int hashCode() {
        return Objects.hash(pedido, produto);
    }

}
