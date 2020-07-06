package com.example.demo.dominio.comercio.cucumber.persistencia;


import com.example.demo.aplicacao.comercio.CarrinhoRepository;
import com.example.demo.aplicacao.inventario.ProdutoRepository;
import com.example.demo.dominio.comercio.Carrinho;
import com.example.demo.dominio.inventario.Produto;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Transactional
public class PassosComPersistencia {


    @Autowired
    CarrinhoRepository carrinhos;

    @Autowired
    ProdutoRepository produtos;

    @Dado("Um Carrinho do email {string} com o subtotal de {double}")
    public void umCarrinhoDoEmailComOSubtotalDe(String donoDoCarrinho,double valorDoCarrinho) {
        carrinhos.save(new Carrinho(valorDoCarrinho, donoDoCarrinho));
    }

    @E("um produto com o nome de {string} e valor de {string}")
    public void umProdutoComONomeDeEValorDe(String nomeDoProduto, String valorDoProduto) {
        produtos.save(new Produto(Double.parseDouble(valorDoProduto), nomeDoProduto));
    }

    @Quando("o {string} for adicionado ao carrinho de {string}")
    public void oForAdicionadoAoCarrinhoDe(String nomeDoProduto, String donoDoCarrinho) {
        Produto produto = produtos.buscaProdutoPorNome(nomeDoProduto);
        Carrinho carrinho = carrinhos.buscaCarrinhoPorEmail(donoDoCarrinho);
        carrinho.adicionaProdutoAoCarrinho(produto);
    }

    @Então("o subtotal do carrinho de {string} terá o valor {string}")
    public void oSubtotalDoCarrinhoDeTeráOValor(String donoDoCarrinho, String subTotalDoCarrinho) {
        Carrinho carrinho = carrinhos.buscaCarrinhoPorEmail(donoDoCarrinho);
        assert carrinho.getPrecoCarrinho().equals(Double.parseDouble(subTotalDoCarrinho));
    }

    @E("os produtos")
    public void osProdutos(DataTable tabela) {
        List<Produto> produtosdoCenario = transformarDeTabelaEmProdutos(tabela);
        produtos.save(produtosdoCenario);
    }

    private List<Produto> transformarDeTabelaEmProdutos(DataTable tabela) {
        ArrayList<Produto> produtosDatabela = new ArrayList<>();
        List<Map<String, String>> maps = tabela.asMaps();
        for(Map<String, String> linha: maps){
            Produto produto = construirDisciplinaPorLinha(linha);
            produtosDatabela.add(produto);
        }
        return produtosDatabela;
    }

    private Produto construirDisciplinaPorLinha(Map<String, String> linha) {
        return new Produto(Double.parseDouble(linha.get("Valor")),linha.get("Produto"));
    }

    @Quando("o Carrinho de {string} receber os produtos")
    public void oCarrinhoDeReceberOsProdutos(String donoDoCarrinho, DataTable tabela) {
        Carrinho carrinho = carrinhos.buscaCarrinhoPorEmail(donoDoCarrinho);
        List<Map<String, String>> mapa = tabela.asMaps();
        for (Map<String, String> linha: mapa){
            Produto produto = produtos.buscaProdutoPorNome(linha.get("Produto"));
            carrinho.adicionaProdutoAoCarrinho(produto);
        }
    }

    @Então("o subtotal do carrinho de {string} terá o valor {double}")
    public void oSubtotalDoCarrinhoDeTeráOValor(String emailDoDono, double valorDoCarrinhoDoCenario) {
        Carrinho carrinho = carrinhos.buscaCarrinhoPorEmail(emailDoDono);
        assert carrinho.getPrecoCarrinho().equals(valorDoCarrinhoDoCenario);
    }
}
