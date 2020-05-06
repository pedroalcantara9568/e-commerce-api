package com.example.demo.aplicacao.rest.autenticacao;

import com.example.demo.aplicacao.comercio.UsuarioRepository;
import com.example.demo.aplicacao.autenticacao.UsuarioService;
import com.example.demo.dominio.autenticacao.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listar(){
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> criaUsuario(@RequestBody Usuario usuario) {
        if(!usuarioService.usuarioPresente(usuario.getEmail())){
            usuarioService.criarUsuario(usuario);
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.badRequest().body(usuario);
    }
}
