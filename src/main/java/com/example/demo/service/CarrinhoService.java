package com.example.demo.service;


import com.example.demo.model.Carrinho;
import com.example.demo.model.Produto;
import com.example.demo.model.Usuario;
import com.example.demo.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoService {


    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public void adicionaProdutoAoCarrinho(Produto produto, Carrinho carrinho) {
        carrinho.setPrecoCarrinho(produto.getValor()+carrinho.getPrecoCarrinho());
        carrinho.getProdutos().add(produto);
        carrinhoRepository.save(carrinho);
    }
}
