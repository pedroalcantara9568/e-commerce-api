package com.example.demo.aplicacao.comercio;

import com.example.demo.dominio.comercio.Carrinho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public void salvarCarrinho(Carrinho carrinho){
        carrinhoRepository.save(carrinho);
    }
}
