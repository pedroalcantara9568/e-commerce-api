package com.example.demo.dominio.comercio;

import com.example.demo.dominio.inventario.Produto;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Entity
public class Carrinho implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Getter
    private Double precoCarrinho;

    @ManyToMany
    private List<Produto> produtos = new ArrayList<Produto>();

    protected Carrinho() {
    }

    public void adicionaProdutoAoCarrinho(Produto produto){
        this.precoCarrinho +=produto.getValor();
        this.produtos.add(produto);
    }

    public Carrinho(Double precoCarrinho){
        this.precoCarrinho = precoCarrinho;
    }

}
