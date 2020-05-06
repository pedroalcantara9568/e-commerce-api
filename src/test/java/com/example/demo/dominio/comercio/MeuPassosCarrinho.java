package com.example.demo.dominio.comercio;

import com.example.demo.dominio.inventario.Produto;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class MeuPassosCarrinho {

    private Produto produto;
    private Carrinho carrinho;

    @Dado("um produto com o valor {double}")
    public void umProdutoComValor (double valor){
        this.produto = new Produto(10);
    }

    @E("um carrinho com o preço {double}")
    public void umCarrinhoComoPreco(double preco){
        this.carrinho = new Carrinho(0.0);
    }

    @Quando("o produto for adicionado ao carrinho")
    public void oProdutoForAdicionadoAoCarrinho(){
        this.carrinho.adicionaProdutoAoCarrinho(produto);
    }

    @Então("o preço do carrinho deve ser o valor do produto")
    public void oPrecodoCarrinhoDeveSerOValorDoProduto(){
        assert this.carrinho.getPrecoCarrinho().equals(this.produto.getValor());
    }



}
