package com.example.demo.aplicacao.comercio;

import com.example.demo.dominio.inventario.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
