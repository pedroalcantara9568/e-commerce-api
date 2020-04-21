package com.example.demo.service;


import com.example.demo.dominio.Carrinho;
import com.example.demo.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public void salvaCarrinho( Carrinho carrinho){
        carrinhoRepository.save(carrinho);
    }
}
