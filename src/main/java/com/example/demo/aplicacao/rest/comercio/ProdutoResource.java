package com.example.demo.aplicacao.rest.comercio;

import com.example.demo.dominio.inventario.Produto;
import java.util.*;
import com.example.demo.aplicacao.inventario.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

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
