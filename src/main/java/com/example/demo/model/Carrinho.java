package com.example.demo.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@EqualsAndHashCode
@Getter
@Entity
public class Carrinho implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Getter
    private Double precoCarrinho;

    @Getter
    @ManyToMany
    private List<Produto> produtos;

    public void adicionaProdutoAoCarrinho(Produto produto){
        this.precoCarrinho += produto.getValor();
        produtos.add(produto);
    }

    public Carrinho() {
    }
}
