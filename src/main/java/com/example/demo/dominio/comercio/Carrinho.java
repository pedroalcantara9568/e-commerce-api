package com.example.demo.dominio.comercio;

import com.example.demo.dominio.inventario.Produto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Entity
@Getter
@Setter
public class Carrinho implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private String emailDoDono;


    private Double precoCarrinho;

    @Getter
    @ManyToMany
    private List<Produto> produtos = new ArrayList<Produto>();

    protected Carrinho (){

    }

    public Carrinho(Double precoCarrinho, String email) {
        this.emailDoDono = email;
        this.precoCarrinho = precoCarrinho;
    }

    public Carrinho(double valor) {
        this.precoCarrinho = valor;
    }

    public void adicionaProdutoAoCarrinho(Produto produto){
        this.precoCarrinho +=produto.getValor();
        this.produtos.add(produto);
    }

}
