
# Projeto de uma rede social

Projeto criado para de estudo de impletação do banco NoSQL MongoDB em uma API REST desenvoldida com Spring Boot e Java no curso de [Java do Nélio Alves](https://www.udemy.com/course/java-curso-completo/)

## Tecnologias utilizadas
- Java 
- Spring Boot
- MongoDB

## Como rodar o Projeto na sua máquina
- Primeiro você deve clonar o Projeto
```
git clone git@github.com:EricklisCruz/workshop-spring-boot-mogodb.git
```
- Depois você deve importar em uma IDE, recomendo fortemente o Intellij IDEA, mas exitem outras opções como o Eclipse.
- Você deve abrir seu MongoDB e criar seu BD com o nome worshop_mogo ou você pode criar com outro nome e alterar no application-test.yml, crie uma collection com o nome user
- Verifique o arquivo application-test.yml e altere se necessário 
- Após importar o projeto você deve iniciar sua aplicação
- A aplicação já possuirá dados pois eles serão adicionados pela classe de configuração Instantiation.java

## Endpoints da aplicação
- User
  
| VERBO | ENDPOINT |
| ----- | ---------|
| GET   | localhost:8080/users/ |
| GET   | localhost:8080/users/{id} |
| GET     | localhost:8080/users/{id}/posts |
| POST    | localhost:8080/users/ |
| PUT    | localhost:8080/users/{id} |
| DELETE    | localhost:8080/users/{id} |

- Post
  
| VERBO | ENDPOINT |
| ----- | -------- |
| GET     | localhost:8080/posts/ |
| GET     | localhost:8080/posts//titlesearch |
| GET     | localhost:8080/users//fullsearch |
