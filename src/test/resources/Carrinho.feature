# language: pt
Funcionalidade: Adicionar produto ao Carrinho

  Cenario de Fundo:
    Dado Um Carrinho do email "alcantara_guitar@hotmail.com" com o subtotal de 0.0

    @persistence
    Delineacao do Cenario: Um Carrinho recebe produtos e altera seu subtotal
      E um produto com o nome de "<NomeDoProduto>" e valor de "<ValorDoProduto>"
      Quando o "<NomeDoProduto>" for adicionado ao carrinho de "alcantara_guitar@hotmail.com"
      Então o subtotal do carrinho de "alcantara_guitar@hotmail.com" terá o valor "<ValorDoProduto>"

      Exemplos:
        |ValorDoProduto |NomeDoProduto |
        |15.0           |Biela         |
        |20.0           |Porca         |
        |17.0           |Parafuso      |
        |20.9           |Eixo Traseiro |

    @persistence
    Cenario: Um Carrinho recebe vários produtos
      E os produtos
      | Produto        | Valor |
      | Biela          | 15.0  |
      | Porca          | 20.0  |
      | Parafuso       | 10.0  |
      | Eixo Dianteiro | 11.0  |
      Quando o Carrinho de "alcantara_guitar@hotmail.com" receber os produtos
      |Produto         |
      |Biela           |
      |Porca           |
      |Parafuso        |
      |Eixo Dianteiro  |
      Então o subtotal do carrinho de "alcantara_guitar@hotmail.com" terá o valor 56.0


