package com.example.demo.dominio.autenticacao;

import com.example.demo.dominio.comercio.Carrinho;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

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
    private Set<Papel> papels;

    @OneToOne
    private Carrinho carrinho;

}
