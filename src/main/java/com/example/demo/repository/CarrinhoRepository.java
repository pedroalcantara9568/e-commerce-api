package com.example.demo.repository;

import com.example.demo.model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository  extends JpaRepository<Carrinho, Long> {

}