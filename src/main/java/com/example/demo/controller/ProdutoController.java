package com.example.demo.controller;

import com.example.demo.model.Produto;
import java.util.*;

import com.example.demo.model.Usuario;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/listar")
    public ResponseEntity<List<Produto>> todosProdutos(){
        return ResponseEntity.ok(produtoRepository.findAll());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto){
        produtoRepository.save(produto);
        return ResponseEntity.ok(produto);
    }
}
