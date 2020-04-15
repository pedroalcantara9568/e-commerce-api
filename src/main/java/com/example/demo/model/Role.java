package com.example.demo.model;

import lombok.*;

import java.io.Serializable;


public class Role implements Serializable {

    private String name;

    public Role(String name) {
        this.name = name;
    }
}
