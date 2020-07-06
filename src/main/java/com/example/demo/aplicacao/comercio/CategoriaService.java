package com.example.demo.aplicacao.comercio;

import com.example.demo.dominio.comercio.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria cadastraCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}
