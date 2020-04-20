# Teste e-commerce

essa API foi desenvolvida usando Java e Spring (Spring-boot) e tem como objetivo um simples cadastro de um pequeno sistema de compras on-line.

##Recomendação
usar Postman para utilizar as credenciais de autenticação e autorização ao utilizar as urls e métodos corretos
    
    Autorization
        TYPE: Basic Auth 
            username: admin@hotmail.com
            password: admin

## Desenvolvimento

o administrador do sistema pode categorias de produtos usando o método POST na url http://localhost:9000/categorias/cadastrar

    {
        "id": "",
        "nome": "Praia"
    }
    
  
o administrador do sistema pode categorias de produtos usando o método POST na url http://localhost:9000/produtos/cadastrar

    {
        "id": "",
        "nome": "Bola",
        "valor": 23.9,
        "categorias": [
            {
                "id": 3,
                "nome": "Praia"
            }
        ]
    }

Um cliente poderá cadastrar-se no sistema com seu e-mail e senha enviando uma requisição do tipo POST para a url: http://localhost:9000/usuarios/cadastrar


    {
        "email": "user@hotmail.com",
        "password": "user"
    }
    
   
Um cliente poderá cadastrar-se no sistema com seu e-mail e senha enviando uma requisição do tipo POST para a url: http://localhost:9000/usuarios/cadastrar


    {
        "email": "user@hotmail.com",
        "password": "user"
    }
   
o cliente poderá cadastrar um produto no seu carrinho usando uma requisição do tipo POST para a url: http://localhost:9000/usuarios/cadastrar


    {
        "id": 3,
        "nome": "Bola",
        "valor": 23.9,
        "categorias": [
            {
                "id": 2,
                "nome": "Praia"
            }
        ]
    }
    
usando o usuario ADMIN vc conseguirá ver a lista de todos os usuarios cadastrados e seus respectivos carrinhos enviando uma requisição do tipo GET para a url: http://localhost:9000/usuarios/listar 


