# language: pt
Funcionalidade: Adicionar produto ao Carrinho

  Cenario: Um produto altera o valor do carrinho
    Dado um carrinho com o preço 0.0
    E um produto com o valor 15.0
    Quando o produto for adicionado ao carrinho
    Então o preço do carrinho será 10.0

  Cenario: Dois produtos alteram o valor do carrinho
    Dado um carrinho com o preço 0.0
    E um produto com o valor 15.0
    E um outro produto com o valor 10.0
    Quando os produtos forem adicionados ao carrinho
    Então o preço do carrinho será 25.0
    
  Cenario: Dois produtos diferentes alteram tamanho da lista de produtos no carrinho
    Dado um carrinho
    E um produto com o valor 10.0
    E um outro produto com o valor 15.0
    Quando os produtos forem adicionados ao carrinho
    Então o numero de produtos no carrinho será 2
    


