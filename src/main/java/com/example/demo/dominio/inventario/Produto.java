package com.example.demo.dominio.inventario;

import com.example.demo.dominio.comercio.Categoria;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@EqualsAndHashCode
@Getter
@Setter
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
}
