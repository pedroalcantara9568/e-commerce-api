package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listar(Principal principal){
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> realizaCadastro(@RequestBody Usuario usuario) {
        if(!usuarioService.usuarioPresente(usuario.getEmail())){
            usuarioService.criarUsuario(usuario);
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.badRequest().body(usuario);
    }
}
