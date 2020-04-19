package com.example.demo.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@EqualsAndHashCode
@Getter
@Setter
@Entity
public class Carrinho implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Getter
    private Double precoCarrinho;

    @Getter
    @Setter
    @ManyToMany
    private List<Produto> produtos;

    public void adicionaProdutoAoCarrinho(Produto produto){
        this.precoCarrinho += produto.getValor();
        this.produtos.add(produto);
    }

    public Carrinho() {
    }

    public Carrinho(Double precoCarrinho){
        this.precoCarrinho = precoCarrinho;
    }
}
