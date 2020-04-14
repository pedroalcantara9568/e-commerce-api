package com.example.demo.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Role implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;

    public Role(String name) {
        this.name = name;
    }

    public Role(String name, List<Usuario> usuarios) {
        this.name = name;
        this.usuarios = usuarios;
    }
}
