package com.example.demo.service;


import com.example.demo.model.Role;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder encoder;

    public void criarUsuario(Usuario usuario) {
        usuario.setPassword(this.encoder.encode(usuario.getPassword()));
        Role userRole = new Role("USER");
        usuario.setRole(userRole);
        usuarioRepository.save(usuario);
    }

    public boolean usuarioPresente (String email) {
        Usuario u = usuarioRepository.findOneByEmail(email);
        if(u!=null)
            return true;
        return false;
    }

    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public Usuario buscaUsuarioPorEmail(String name) {
        return usuarioRepository.findOneByEmail(name);
    }
}
