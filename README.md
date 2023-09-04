## [Tech Challenge - FastFood](#Tech Challenge)

Sistema para gerenciamento de pedidos

### Índice

* [Contexto](#contexto)
* [Módulo de Infra e Aplicação](#Módulo_De_Infra_E_Aplicacao)
* [Módulo Core](#dominio)
* [Tecnologias](#tecnologias)
* [Instruções para iniciar o projeto](#instruções-para-iniciar-o-projeto)
* [Grupo 7](#grupo-7)

***
### [Contexto](#Contexto)
Fase 1 e 2 do Tech Challenge do curso de Arquitetura de Software
da Pós Tech FIAP 2023 usando os conceitos de DDD, Clean Architecture, Solid e K8s. Diferentemente da fase 1, na fase 2 optamos por 
dividir o sistema em módulos para manter, além de um isolamento lógico, também um isolamento físico entre as camadas. Optamos por dividir da seguinte maneira:

* fastfood-management-system: módulo pai.
* fastfood-system-application: módulo que contém API, também responsável pela inicialização da aplicação.
* fastfood-system-core: módulo que contém a camada de domínio isolada do resto da aplicação.
* fastfood-system-infra: módulo com as configurações de persistência e infraestrutura geral do projeto.

### [Módulo de Infra e Aplicação](#Módulo_De_Infra_E_Aplicacao)

<p>Utilizamos o módulo de infra para criar as entidades e operações (implementações) de persistência de dados, criar classes
de conversão para interação com domínio, além de definição de exceções para tratamento de erros. Nessa camada tomamos
liberdade de utilizar anotaçoes, principalmente as referente a pesistência de dados (com JPA) no MongoDB e do framework utilizado (Spring),
pois entendemos que não estamos violando a camada mais interna de domínio.</p>

<p>No módulo de aplicação definimos a API para acesso as operações e usecases (via interface), error handler e configurações de inicialização e 
criação de beans do projeto. É no módulo de aplicação que se encontram os arquivos para criação dos artefatos kubernetes como os deployments,
services... etc. Aqui também utilizamos anotações do framework para facilitar as configurações e gerenciamento geral do projeto.

### [Módulo Core](#Dominio)

<p>O módulo core contém as classes de domínio é composto pelas entidades: Cliente, Pedido, Produto e Funcionário.</p> 

<p>Construímos as classes de domínio com suas respectivas interfaces e usecases no módulo fastfood-system-core e 
isolamos essa camada de todo resto da aplicação. Dentre as estratégias e boas práticas para garantir o isolamento, 
utilizamos:</p>

* Acesso e manipulação das classes de domínio apenas via usecases e interfaces.
* Separação de usecases em classes distintas para garantir o principio de responsabilidade única e garantir o baixo acoplamento.
* Ausência de anotações de frameworks e bibliotecas, garantindo o desacoplamento tecnológico.
* Implementação baseada em interfaces e inversão de dependência na camada de usecases.
* Validações e divisão em pacotes garantindo uma visualização mais clara do contexto do projeto.

<p>Segue abaixo uma breve descrição das operações implementadas em cada classe do domínio.</p>


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
  "valorTotal": 16.0,
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
#### **Pagamento**
- Geração de QRCode para pagamento por número do pedido(integração com Mercado Pago)
- Consulta do status do pagamento por número do pedido
- Webhook para confirmação e atualização do pagamento

Exemplo Payload :
```javascript
{
  "id": "12345",
  "action": "payment.created",
  "date_created": "2023-09-04T02:12:43.814Z",
  "data": {
    "id": "999999999"
  }
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
   * kubectl apply -f components.yaml

<p>Obs: optamos por utilizar secrets do tipo Opaque como demonstrado nas aulas</p>

<p>3.  Aplicação disponível em: http://localhost:8080/swagger-ui/index.html#/ .



### [Grupo 7](#grupo-7)
***
* Jackson Carlos Leite Ramalho (jacksoncarloslr@gmail.com)
* Valqueline Nicácio da Silva (valqueline.nicacio@gmail.com)
