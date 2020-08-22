# Gateway API - Bruno Felix
Projeto desenvolvido para servir como proxy para o consumo da API do governo federal que detém os dados da covid-19.

## Pré-requisitos

Para buildar e executar a aplicação (API e Front-end) será necessário:
* 	[Maven](https://maven.apache.org/) - Dependency Management.
* 	[JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit.
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications.
* 	[MySQL](https://www.mysql.com/) - Open-Source Relational Database Management System.
* 	[git](https://git-scm.com/) - Free and Open-Source distributed version control system.
* 	[Swagger](https://swagger.io/) - Open-Source software framework backed by a large ecosystem of tools that helps developers design, build, document, and consume RESTful Web services.

## Documentação
* 	[Swagger](http://localhost:8080/swagger-ui.html) - Documentação dos serviços disponibilizado pela API.

## Arquivos e diretórios

O projeto foi criado e desenvolvido seguindo a estrutura descrita abaixo:

* 	[API]
```
.
├── Spring Elements
├── src
│   └── main
│       └── java
│           ├── br.com.bruno.felix.api.gateway.controller
│	├── br.com.bruno.felix.api.gateway.exception
│           ├── br.com.bruno.felix.api.gateway.model
│           ├── br.com.bruno.felix.api.gateway.repository
│           ├── br.com.bruno.felix.api.gateway.service
├── src
│   └── main
│       └── resources
│           ├── application.properties
├── src
│   └── test
│       └── java
            ├── br.com.bruno.felix.api.gateway.unit
                ├── br.com.bruno.felix.api.gateway.unit.controller
                ├── br.com.bruno.felix.api.gateway.unit.service
        └── Resources
├── JRE System Library
├── Maven Dependencies
├── src
├── target
├── mvnw
├── mvnw.cmd
├── pom.xml

```

## Pacotes

* 	[API]
- `controller` - Pasta responsável pelo mapeamento e direcionamento das ações recebidas (request) pela camada da apresentação para os respectivos serviços da aplicação.
- `exception` - Pasta responsável pelo armazenamento de classes que tratam as exceções;
- `model` - Pasta responsável pelo armazenamento de classes básicas e de respostas (response);
- `repository` - Pasta responsável pelo armazenamento de arquivos que realizam consultas na base de dados;
- `service` - Pasta responsável pelo armazenamento dos arquivos que detalham os serviços da aplicação consumindo os arquivos as pasta repository;
- `resources/application.properties` - Arquivo que contem as propriedades do sistema, como os dados de conexão do banco de dados.
- `test/` - Pacote onde se encontram os testes unitários.
- `pom.xml` - Arquivo onde se encontram todas as dependências do projeto.

## Instalação

* Clonar o repositório utilizando o seguinte comando no Git: 

```git
git clone https://github.com/BrunoFelix/gatewayapi.git
```

* Acessar pasta do projeto clonado e executar o seguinte comando:

```git
mvn install
```

* O arquivo JAR executável agora está disponível no diretório target e podemos iniciar o aplicativo executando o seguinte comando na linha de comando:

```java
java -jar target/gatewayapi-0.0.1-SNAPSHOT.jar
```

## Liçensa
* 	Apache License 2.0. Visualizar arquivo de [LICENSE](https://github.com/BrunoFelix/gatewayapi/blob/master/LICENSE).
