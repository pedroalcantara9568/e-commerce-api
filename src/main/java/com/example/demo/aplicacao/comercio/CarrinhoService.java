package com.example.demo.aplicacao.comercio;

import com.example.demo.dominio.comercio.Carrinho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public Carrinho salvarCarrinho(Carrinho carrinho){
       return carrinhoRepository.save(carrinho);
    }

    public Carrinho buscaCarrinhoPorEmail(String email) {
        return carrinhoRepository.buscaCarrinhoPorEmail(email);
    }
}
