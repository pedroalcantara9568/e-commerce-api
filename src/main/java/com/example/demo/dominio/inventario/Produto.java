package com.example.demo.dominio.inventario;

import com.example.demo.dominio.comercio.Categoria;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Set;

@EqualsAndHashCode
@Getter
@Entity
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    private Double valor;

    @ManyToMany
    private Set<Categoria> categorias;

    protected Produto() {
    }

    public Produto (double valor) {
        this.valor = valor;
    }

    public Produto(double valorDoProduto, String nomeDoProduto) {
        this.nome = nomeDoProduto;
        this.valor = valorDoProduto;

    }
}
