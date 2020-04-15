package com.example.demo.model;

import lombok.Getter;
import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class Role implements Serializable {

    @Getter
    private String roleName;

    protected Role() {

    }

    public Role(String name) {
        this.roleName = name;
    }
}
