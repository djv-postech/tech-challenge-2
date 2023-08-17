## [Tech Challenge](#Tech Challenge)

Sistema para gerenciamento de pedidos, contendo as APIs:

### Índice

* [Contexto](#contexto)
* [Domínio](#dominio)
* [Tecnologias](#tecnologias)
* [Instruções para iniciar o projeto](#instruções-para-iniciar-o-projeto)
* [Grupo 7](#grupo-7)

***
### [Contexto](#Contexto)
Fase 1 do Tech Challenge do curso de Arquitetura de Software
da Pós Tech FIAP 2023 usando os conceitos de DDD e Arquitetura Hexagonal.


### [Domínio](#Dominio)
O domínio é composto pelas entidades Cliente, Pedido, Produto e Funcionário.
Segue abaixo uma breve descrição das operações implementadas em cada classe do domínio.

#### **Cliente**
- Cadastro de novos clientes
- Identificação de clientes por CPF
- Exclusão de clientes por CPF
- Atualização de clientes
- Listagem de todos clientes

    
Exemplo Payload :
```javascript
{
  "nome": "Nome Sobrenome",
  "cpf": "123.456.789-09",
  "email": "email_usuario@email.com"
}
```

#### **Produto**
  - Cadastro de produto
  - Listagem de produto por Id
  - Atualização de produto
  - Remoção de produto
  - Listagem de todos os produtos
  - Listagem de produtos por categoria
  
Exemplo Payload:
```javascript
{
  "nome": "Cheese Burger",
  "descricao": "pao, hamburguer, alface, queijo, molho especial",
  "preco": 10.5,
  "quantidade": 1,
  "categoria": "LANCHE"
}
```

#### **Pedido**
- Cadastro de novos pedidos
- Listagem de pedido por Id
- Listagem de pedidos por status
- Listagem de todos os pedidos
- Atualização do status do pedido

Exemplo Payload:
```javascript
{
  "cliente":{
    "nome":"Nome Sobrenome",
    "cpf":"123.456.789-09",
    "email":"email_usuario@email.com"
  },
  "produtos":[
    {
      "nome":"Cheese Burger",
      "descricao":"pao, hamburguer, alface, queijo, molho especial",
      "preco":10.5,
      "quantidade":1,
      "categoria":"LANCHE"
    },
    {
      "nome":"Suco de Laranja",
      "descricao":"suco natural de laranja",
      "preco":5.5,
      "quantidade":1,
      "categoria":"BEBIDA"
    }
  ],
  "pagamento":{
    "tipoPagamento":"QRCODE",
    "totalPagamento": 16.0,
    "dataPagamento":"2023-07-07T14:48:33.220Z",
    "statusPagamento":"PROCESSANDO"
  },
  "statusPedido":"RECEBIDO",
  "dataCriacaoPedido":"2023-07-07T14:49:33.220Z"
}
```


### [Tecnologias](#Tecnologias)
***
* Java
* Spring Boot
* Swagger
* Spring Data MongoDB
* Docker


### [Instruções para iniciar o projeto](#Instruções para iniciar o projeto)
***
1.  mvn clean && mvn install
2.  docker build -t tech-challenge:latest .
3.  docker-compose up
4.  Aplicação disponível em: http://localhost:8080/swagger-ui/index.html#/ .



### [Grupo 7](#grupo-7)
***
* Jackson Carlos Leite Ramalho (jacksoncarloslr@gmail.com)
* Valqueline Nicácio da Silva (valqueline.nicacio@gmail.com)
* Daniel Melo (danielmelowork@gmail.com)
