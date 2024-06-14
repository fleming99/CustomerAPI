# Customer Management Microservice

## Descrição

Este projeto é um microsserviço de gerenciamento de clientes, desenvolvido utilizando Spring. A API RESTful permite realizar operações CRUD nos objetos `Customer`, `CustomerAddress` e `CustomerRoles`, que estão relacionados entre si. 

## Tecnologias Utilizadas

- **Java**
- **Spring Framework**
- **MySQL**: Utilizado como banco de dados.
- **Docker**: O banco de dados foi containerizado por ser mais ágil para testar.
- **Postman**: Utilizado para testar a API.
- **Conceitos**: Clean Code, Clean Architecture, REST.

## Funcionalidades

A API permite as seguintes operações CRUD:

### Customer

- **Create**: Adicionar um novo cliente.
- **Read**: Buscar um cliente pelo ID ou listar todos os clientes.
- **Update**: Atualizar as informações de um cliente existente.
- **Delete**: Remover um cliente.

## Estrutura do Projeto

A estrutura do projeto segue os princípios de Clean Architecture, garantindo que o código seja modular, fácil de manter e escalável.


## Configuração do Banco de Dados

No arquivo `application.properties`, configure suas credenciais do MySQL:

```
spring.datasource.url=your_url
spring.datasource.username=your_username
spring.datasource.password=your_password
```

## Testando a API
Utilize o Postman para testar os endpoints da API.

### Endpoints:

### Customers:
- **POST** /customers: Adicionar um novo cliente.
- **GET** /customers/{id}: Buscar um cliente pelo ID.
- **GET** /customers: Listar todos os cliente.
- **PUT** /customers/{id}: Atualizar um cliente existente.
- **DELETE** /customers/{id}: Remover um cliente.

