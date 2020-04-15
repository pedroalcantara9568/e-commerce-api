package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Role implements Serializable {

    private String roleName;

    public Role(String name) {
        this.roleName = name;
    }
}
