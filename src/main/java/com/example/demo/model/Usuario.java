package com.example.demo.model;

import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    Long id;

    @Email
    @Column(unique = true)
    private String email;

    @NotEmpty(message = "esse campo não pode ser nulo")
    private String password;

    @Embedded
    private Role role;

    protected Usuario (){

    }

}
