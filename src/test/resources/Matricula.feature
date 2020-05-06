# language: pt
Funcionalidade: Adicionar produto ao Carrinho

  Cenário: Um produto altera o valor do Carrinho
    Dado um produto com o valor 10.0
    E um carrinho com o preço 0.0
    Quando o produto for adicionado ao carrinho
    Então o preço do carrinho deve ser o valor do produto
