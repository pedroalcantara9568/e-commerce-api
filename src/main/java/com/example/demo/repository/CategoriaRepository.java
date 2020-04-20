package com.example.demo.repository;

import com.example.demo.dominio.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


}
