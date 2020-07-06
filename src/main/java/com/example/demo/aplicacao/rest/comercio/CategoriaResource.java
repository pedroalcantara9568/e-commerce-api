package com.example.demo.aplicacao.rest.comercio;

import com.example.demo.aplicacao.comercio.CategoriaRepository;
import com.example.demo.aplicacao.comercio.CategoriaService;
import com.example.demo.dominio.comercio.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/categoria")
public class CategoriaResource {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> listar() {
        return ResponseEntity.ok(categoriaRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Categoria> cadastrarCategoria(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.cadastraCategoria(categoria));
    }

}