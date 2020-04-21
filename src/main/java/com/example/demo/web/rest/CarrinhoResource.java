package com.example.demo.web.rest;


import com.example.demo.dominio.Carrinho;
import com.example.demo.dominio.Produto;
import com.example.demo.dominio.Usuario;
import com.example.demo.service.CarrinhoService;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@RequestMapping("/carrinho")
public class CarrinhoResource {

    @Autowired
    private CarrinhoService carrinhoService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/adicionarProduto")
    public ResponseEntity<Carrinho> cadastraProdutoNoCarrinho(@RequestBody Produto produto, Principal principal) {
        Usuario donoDoCarrinho = usuarioService.buscaUsuarioPorEmail(principal.getName());
        carrinhoService.adicionaProdutoAoCarrinho(produto, donoDoCarrinho.getCarrinho());
        return  ResponseEntity.ok(donoDoCarrinho.getCarrinho());
    }
}
