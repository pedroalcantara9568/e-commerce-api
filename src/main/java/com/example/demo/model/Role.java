package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Role implements Serializable {

    private String nome;

    public Role(String nome) {
        this.nome = nome;
    }
}
