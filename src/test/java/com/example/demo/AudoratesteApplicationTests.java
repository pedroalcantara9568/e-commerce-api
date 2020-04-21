package com.example.demo;

import com.example.demo.dominio.Carrinho;
import com.example.demo.dominio.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class AudoratesteApplicationTests {


    @Test
    @DisplayName("Adicionar produto ao carrinho altera o Valor")
    public void adicionarProdutoAoCarrinhoAlteraOValor(){

        //DADO: UM CARRINHO COM PRECO DE 0.0 E UM PRODUTO COM O VALOR DE 10.0
        Produto produto = new Produto();
        produto.setValor(10.0);
        Carrinho carrinho = new Carrinho(0.0);

        //QUANDO: O PRODUTO ADICIONADO AO CARRINHO
        carrinho.adicionaProdutoAoCarrinho(produto);

        //ENTÃO: O VALOR DO CARRINHO SERÁ O MESMO DO PRODUTO
        Assertions.assertEquals(produto.getValor(),carrinho.getPrecoCarrinho());
    }

}
