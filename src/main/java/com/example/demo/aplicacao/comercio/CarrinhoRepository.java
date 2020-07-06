package com.example.demo.aplicacao.comercio;

import com.example.demo.dominio.comercio.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CarrinhoRepository  extends JpaRepository<Carrinho, Long> {


    @Query("select carrinho from Carrinho carrinho where carrinho.emailDoDono= :email")
    Carrinho buscaCarrinhoPorEmail( @Param("email") String email);
}
