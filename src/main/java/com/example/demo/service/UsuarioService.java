package com.example.demo.service;


import com.example.demo.dominio.Carrinho;
import com.example.demo.dominio.Role;
import com.example.demo.dominio.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CarrinhoService carrinhoService;

    @Autowired
    private PasswordEncoder encoder;

    public void criarUsuario(Usuario usuario) {
        usuario.setPassword(this.encoder.encode(usuario.getPassword()));
        Role userRole = new Role("USER",Long.valueOf(2));
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        usuario.setRoles(roles);
        Carrinho carrinho = new Carrinho(0.0);
        carrinhoService.salvaCarrinho(carrinho);
        usuario.setCarrinho(carrinho);
        usuarioRepository.save(usuario);
    }

    public boolean usuarioPresente (String email) {
        Usuario u = usuarioRepository.buscaPorEmail(email);
        if(u!=null)
            return true;
        return false;
    }

    public Usuario buscaUsuarioPorEmail(String name) {
        return usuarioRepository.buscaPorEmail(name);
    }
}
