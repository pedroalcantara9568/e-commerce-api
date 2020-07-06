package com.example.demo.dominio.comercio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Categoria {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String nome;

    protected Categoria() {
    }

}
