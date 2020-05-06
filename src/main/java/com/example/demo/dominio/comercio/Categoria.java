package com.example.demo.dominio.comercio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Categoria {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    protected Categoria() {
    }
}
