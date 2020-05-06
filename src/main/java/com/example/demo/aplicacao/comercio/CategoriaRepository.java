package com.example.demo.aplicacao.comercio;

import com.example.demo.dominio.comercio.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


}
