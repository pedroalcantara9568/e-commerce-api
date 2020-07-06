package com.example.demo.aplicacao.inventario;

import com.example.demo.dominio.inventario.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("select p from Produto p where p.nome= :nomeDoProduto")
    Produto buscaProdutoPorNome(@Param("nomeDoProduto") String nomeDoProduto);

}
