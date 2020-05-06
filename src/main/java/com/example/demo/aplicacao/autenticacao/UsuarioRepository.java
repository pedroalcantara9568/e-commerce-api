package com.example.demo.aplicacao.autenticacao;

import com.example.demo.dominio.autenticacao.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    @Query("select u from Usuario u where u.email= :email")
    Usuario buscaPorEmail (@Param("email") String email);

}
