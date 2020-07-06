package com.example.demo.aplicacao.rest.autenticacao;

import com.example.demo.aplicacao.autenticacao.UsuarioRepository;
import com.example.demo.aplicacao.autenticacao.UsuarioService;
import com.example.demo.dominio.autenticacao.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Usuario>> listar(){
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Usuario> criaUsuario(@RequestBody Usuario usuario) {
        if(!usuarioService.usuarioPresente(usuario.getEmail())){
            usuarioService.criarUsuario(usuario);
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.badRequest().body(usuario);
    }
}
