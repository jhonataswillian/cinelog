# Cinelog

## Descrição

Cinelog é um sistema de catálogo de filmes desenvolvido em Java utilizando o framework Spring Boot. O projeto tem como objetivo fornecer uma API REST para o gerenciamento de filmes, permitindo operações de cadastro e listagem.

## Tecnologias Utilizadas

O projeto foi desenvolvido utilizando as seguintes tecnologias e bibliotecas:

- Java 25
- Spring Boot 4.0.2
- Spring Web MVC
- Spring Data JPA
- H2 Database (Banco de dados em memória)
- Lombok
- Maven

## Funcionalidades

A API fornece os seguintes endpoints para gerenciamento de filmes:

### Filmes

- **POST /filmes/cadastrar**: Cadastra um novo filme no catálogo.
  - O corpo da requisição deve conter um objeto JSON com os campos: `titulo`, `genero`, `nota` e `assistido`.
- **GET /filmes**: Retorna a lista de todos os filmes cadastrados.

## Estrutura do Projeto

O projeto segue a arquitetura em camadas padrão do Spring Boot:

- **Controller**: Camada responsável por expor os endpoints da API (ex: `FilmeController`).
- **Service**: Camada de regras de negócio (ex: `FilmeService`).
- **Repository**: Camada de acesso a dados (ex: `FilmeRepository`).
- **Entity**: Representação das tabelas do banco de dados (ex: `Filme`).

## Como Executar

Para executar o projeto localmente, certifique-se de ter o JDK 25 e o Maven instalados.

1. Clone o repositório.
2. Navegue até o diretório raiz do projeto.
3. Execute o comando para compilar e rodar a aplicação:

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.
