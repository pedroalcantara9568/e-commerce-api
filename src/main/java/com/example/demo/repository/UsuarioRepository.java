package com.example.demo.repository;

import com.example.demo.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    @Query("select u from Usuario u where u.email= :email")
    Usuario buscaPorEmail (@Param("email") String email);

}
