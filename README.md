# Livro Já
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/Muriloabreu/livro_ja/blob/main/LICENCE) 

# Sobre o projeto


Livro Já é uma API REST.

A API consiste em cadastrar Livros (CRUD), clientes (CRUD) e realizar alugueis (CRUD) de livros.



# Tecnologias utilizadas
## Back end
- Java
- Maven
- Spring Boot



## Implantação em produção

- Banco de dados: Postgres 9.5

## Back end
- Pré-requisitos: Java 17

# Como executar o projeto

Necessário ter um servidor Tomcat para poder rodar o projeto Java

##  Utilize uma plataforma de consultas de API's e faça a requisição de acordo os modelos disponíveis na sessão abaixo.
</code></pre>
 - Modelos de requisição JSON
</p>

</P>
<h5>Livros</h5>

```json
{
    
    "titulo": "Java para Iniciantes",
    "autor": "Herbert Schildt",
    "lingua": "Pt-br",
    "editora": "bookman",
    "paginas": 600,
    "genero": "Tecnologia"
    
}
```
</p>
<h5>Clientes</h5>

```json
{
    "nome": "André",
    "sobrenome": "Silva",
    "cpf": 31673948030,
    "email": "AndréBac4no9@teste.com",
    "telefone": 99999999999
}
```
</p>
<h5>Alugueis</h5>

```json
{
        "id": "a611d492-9dd4-497d-8d00-a03322e35118",
        "livro": {
            "id": "1b9bc813-8f8a-400a-9a22-fd1800889874",
            "titulo": "Spring boot",
            "autor": "JAVA ",
            "lingua": "Pt-br",
            "editora": "JAJAJA",
            "paginas": 905,
            "genero": "Tecnologia"
        },
        "cliente": {
            "id": "8a9d31e3-226b-4da9-ba5f-5a58e3551f66",
            "nome": "Antônio",
            "sobreNome": "Souza",
            "cpf": "21673948009",
            "telefone": "999945503"
        },
        "dataInicio": "2023-04-11T15:06:07.516908",
        "dataFim": "04/20/2023"
    }
```
</p>
</p>

```bash
# clonar repositório
git clone git@github.com:Muriloabreu/livro_ja.git

```

# Autor

Murilo Abreu do Nascimento

https://www.linkedin.com/in/murilo-abreu-07544973/
