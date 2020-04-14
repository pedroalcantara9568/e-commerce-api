package com.example.demo.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String name;

    public Role(String name) {
        this.name = name;
    }
}
