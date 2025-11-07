# Adoção de Pets API
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)

## Sobre o Projeto
Este projeto é uma API que gerencia um sistema de adoção de pets, onde ONGs iriam resgatá-los e pessoas poderiam adotá-los. Este projeto contém operações CRUD em todas as entidades além de outras operações personalizadas. Desenvolvido com Java Sring Boot, e MySQL como banco de dados. Construído com o intuito de aplicar meu conhecimentos adquiridos na linguagem Java, criação de APIs REST, modelagem conceitual, lógica e física de banco de dados, além de scripts SQL para consultas personalizadas.

## Tecnologias Utilizadas
- Java 21
- Spring Boot 3.5.7
- Spring Web
- Spring Validation
- SpringDoc - OpenAPI (Swagger)
- MySQL
- Lombok

## Executando o Projeto

### Passos
1. Clone esse repositório:
```bash
git clone https://github.com/zNathan2303/adocao-pets-spring-boot
```
2. Coloque as credenciais do seu usuário MySQL no *application.properties*:
```properties
spring.datasource.username=root
spring.datasource.password=root
```
3. Crie um banco de dados no seu MySQL chamado db_adocao_pets.
4. Inicie o projeto e as tabelas serão criadas automáticamente e será inserido os dados do *data.sql*.
5. Inicie o projeto e teste os endpoints em: http://localhost:8080/swagger-ui/index.html#/


## Autor
[Nathan da Silva Costa](<https://www.linkedin.com/in/nathandasilvacosta/>)