package com.example.demo.controller;


import com.example.demo.model.Carrinho;
import com.example.demo.model.Produto;
import com.example.demo.model.Usuario;
import com.example.demo.repository.CarrinhoRepository;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;


@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/adicionarProduto")
    public ResponseEntity<Carrinho> cadastrarProdutoNoCarrinho(@RequestBody Produto produto, Principal principal) {
        Usuario donoDoCarrinho = usuarioRepository.findOneByEmail(principal.getName());
        carrinhoService.adicionaProdutoAoCarrinho(produto, donoDoCarrinho.getCarrinho());
        return  ResponseEntity.ok(donoDoCarrinho.getCarrinho());
    }
}
