package com.example.demo.controller;


import com.example.demo.model.Carrinho;
import com.example.demo.model.Produto;
import com.example.demo.model.Usuario;
import com.example.demo.repository.CarrinhoRepository;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.*;


@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/adicionarProduto")
    public ResponseEntity<Carrinho> adicionaProdutoAoCarrinho(@RequestBody Produto produto, Principal user){
       Usuario usuarioLogado = usuarioRepository.findOneByEmail(user.getName());
       usuarioLogado.getCarrinho().adicionaProdutoAoCarrinho(produto);
       usuarioRepository.save(usuarioLogado);
       return ResponseEntity.ok(usuarioLogado.getCarrinho());
    }
}
