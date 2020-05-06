package com.example.demo.aplicacao.autenticacao;

import com.example.demo.aplicacao.comercio.CarrinhoService;
import com.example.demo.aplicacao.comercio.UsuarioRepository;
import com.example.demo.dominio.autenticacao.Papel;
import com.example.demo.dominio.autenticacao.Usuario;
import com.example.demo.dominio.comercio.Carrinho;
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
        Papel userPapel = new Papel("USER",Long.valueOf(2));
        Set<Papel> papels = new HashSet<>();
        papels.add(userPapel);
        usuario.setPapels(papels);
        Carrinho carrinho = new Carrinho(0.0);
        carrinhoService.salvarCarrinho(carrinho);
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
