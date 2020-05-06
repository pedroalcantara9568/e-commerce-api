package com.example.demo.aplicacao.rest.comercio;


import com.example.demo.aplicacao.comercio.CarrinhoRepository;
import com.example.demo.aplicacao.autenticacao.UsuarioService;
import com.example.demo.dominio.autenticacao.Usuario;
import com.example.demo.dominio.comercio.Carrinho;
import com.example.demo.dominio.inventario.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;


@RestController
@RequestMapping("/carrinho")
public class CarrinhoResource {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/adicionarProduto")
    public ResponseEntity<Carrinho> cadastraProdutoNoCarrinho(@RequestBody Produto produto, Principal principal) {
        Usuario donoDoCarrinho = usuarioService.buscaUsuarioPorEmail(principal.getName());
        donoDoCarrinho.getCarrinho().adicionaProdutoAoCarrinho(produto);
        return ResponseEntity.ok(carrinhoRepository.save(donoDoCarrinho.getCarrinho()));
    }
}
