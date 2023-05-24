
# Trabalho 01 - Framework Spring

Uma api para criação e visualização de jogadores e criação e visualização de pagamentos.


## Stack utilizada

**Dependências** 
* Spring Web
* Spring Data JPA
* PostgreSQL Driver

**Configurações**
* Maven
* Java 17
* Spring Boot:3.0.7


## Documentação da API

#### Listar todos os jogadores

```http
  GET /api/jogador/
```

#### Criar um jogador

```http
  POST /api/jogador
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `string` | **Obrigatório**. Nome do jogador |
| `email`      | `string` | **Obrigatório**. Email do jogador |
| `datanasc`      | `string` | **Obrigatório**. Data de nascimento do jogador. Formato *yyyy-MM-dd* |

#### Listar os pagamentos

```http
  GET /api/pagamento
```

#### Filtrar pagamentos pelo código do jogador

```http
  GET /api/pagamento/{codJogador}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `codJogador`      | `string` | **Obrigatório**. Código do jogador |

#### Criar um pagamento

```http
  POST /api/pagamento
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `ano`      | `int` | **Obrigatório**. Ano do pagamento |
| `mes`      | `int` | **Obrigatório**. Mês do pagamento |   
| `valor`      | `float` | **Obrigatório**. Valor do pagamento |
| `codJogador`      | `int` | **Obrigatório**. Código do jogador |


