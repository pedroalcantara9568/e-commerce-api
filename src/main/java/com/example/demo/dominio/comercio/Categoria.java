package com.example.demo.dominio.comercio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Categoria {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    protected Categoria() {
    }
}
