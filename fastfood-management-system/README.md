## [Tech Challenge - FastFood](#Tech Challenge)

Sistema para gerenciamento de pedidos

### Índice

* [Contexto](#contexto)
* [Domínio](#dominio)
* [Tecnologias](#tecnologias)
* [Instruções para iniciar o projeto](#instruções-para-iniciar-o-projeto)
* [Grupo 7](#grupo-7)

***
### [Contexto](#Contexto)
Fase 1 e 2 do Tech Challenge do curso de Arquitetura de Software
da Pós Tech FIAP 2023 usando os conceitos de DDD, Clean Architecture, Solid e K8s. Diferentemente da fase 1, na fase 2 optamos por 
dividir o sistema em módulos para manter, além de um isolamento lógico, também um isolamento físico entre as camadas. Optamos por dividir da seguinte maneira:

* fastfood-management-system: módulo pai.
* fastfood-system-application: módulo que contem API, também responsável pela inicialização da aplicação.
* fastfood-system-core: módulo que contém a camada de domínio isolada do resto da aplicação.
* fastfood-system-infra: módulo com as configurações de persistência e infraestrutura geral do projeto.


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
* Kubernetes


### [Instruções para iniciar o projeto](#Instruções para iniciar o projeto)
***
<p>1.  mvn clean install
<p>O comando acima fará o build do projeto e também irá gerar a imagem com nome: <strong>techchallenge/fastfood:0.0.1-SNAPSHOT</strong>

<p>2. Para subir a aplicação será necessário executar os comandos para geração dos artefatos do k8s:
O comando em questão é o: <strong>kubectl apply -f NOME_ARTEFATO.yml </strong> Os arquivos se encontram na pasta k8s dentro do modulo: <strong>fastfood-system-application</strong>
<p> Lista ordenada dos artefatos a serem criados:
   
   * kubectl apply -f fastfood-mongo-secrets.yml
   * kubectl apply -f fastfood-secrets.yml
   * kubectl apply -f fastfood-mongo-svc.yml
   * kubectl apply -f fastfood-svc.yml
   * kubectl apply -f fastfood-mongo-pvc.yml
   * kubectl apply -f fastfood-mongo-statefulset.yml
   * kubectl apply -f fastfood-deployment.yml
   * kubectl apply -f fastfood-hpa.yml

<p>Obs: optamos por utilizar secrets do tipo Opaque como demonstrado nas aulas</p>

<p>3.  Aplicação disponível em: http://localhost:8080/swagger-ui/index.html#/ .



### [Grupo 7](#grupo-7)
***
* Jackson Carlos Leite Ramalho (jacksoncarloslr@gmail.com)
* Valqueline Nicácio da Silva (valqueline.nicacio@gmail.com)
