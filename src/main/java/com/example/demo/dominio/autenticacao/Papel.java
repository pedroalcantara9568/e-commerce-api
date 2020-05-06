package com.example.demo.dominio.autenticacao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Papel implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    protected Papel(){

    }

    public Papel(String nome, Long id) {
        this.nome = nome;
        this.id = id;
    }
}
