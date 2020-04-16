package com.example.demo.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@EqualsAndHashCode
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
