package com.example.demo.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.*;
import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Email
    @Column(unique = true)
    private String email;

    @NotEmpty(message = "esse campo não pode ser nulo")
    private String password;

    @ManyToMany
    private Set<Role> roles;

    @OneToOne
    private Carrinho carrinho;



}
