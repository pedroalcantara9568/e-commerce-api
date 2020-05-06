package com.example.demo.aplicacao.comercio;

import com.example.demo.dominio.comercio.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository  extends JpaRepository<Carrinho, Long> {

}
