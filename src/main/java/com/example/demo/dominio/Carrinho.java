package com.example.demo.dominio;

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

    @ManyToMany
    private List<Produto> produtos;

    public Carrinho() {
    }

    public Carrinho(Double precoCarrinho){
        this.precoCarrinho = precoCarrinho;
    }

}
