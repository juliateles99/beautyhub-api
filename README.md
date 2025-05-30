## BeautyHub Project

Olá! Este é o BeautyHub, um projeto full-stack desenvolvido para demonstrar habilidades em Java com Spring Boot para o backend e Angular para o frontend. A ideia é simular uma plataforma simples para visualização e gerenciamento de produtos de beleza.

O foco está na construção da lógica de backend para um CRUD de Produtos e na sua apresentação e interação em um frontend dinâmico.

---

## O que o projeto faz?

O sistema BeautyHub permite gerenciar e visualizar produtos de beleza, com as seguintes funcionalidades principais:

### Backend (BeautyHub API)

* **Gerenciamento de Produtos:**
    * Permite cadastrar novos produtos (`POST /products`).
    * Lista todos os produtos, com filtros opcionais por nome e/ou categoria (`GET /products`).
    * Atualiza informações de um produto existente (`PUT /products/{id}`).
    * Remove um produto do catálogo (`DELETE /products/{id}`).
    * Utiliza DTOs (Data Transfer Objects) para a comunicação e MapStruct para o mapeamento entre entidades e DTOs.
* **API Documentation:**
    * Disponibiliza uma interface Swagger UI para fácil exploração e teste dos endpoints da API (graças à dependência `springdoc-openapi-starter-webmvc-ui`).

### Frontend (BeautyHub Frontend)

* **Visualização de Produtos:**
    * Exibe uma lista de produtos de forma organizada em cards.
    * Mostra nome, imagem, categoria, preço e avaliação de cada produto.
    * Apresenta uma mensagem amigável caso nenhum produto seja encontrado.
* **Interação com Produtos:**
    * Permite excluir produtos diretamente da lista, com uma confirmação.
* **Comunicação com Backend:**
    * Consome a API do BeautyHub para buscar e deletar produtos.

---

## Tecnologias Utilizadas 🛠️

Para construir este projeto, foram utilizadas as seguintes tecnologias e ferramentas:

### Backend (beautyhub-api)

* **Linguagem:** Java 17
* **Framework Principal:** Spring Boot 3.4.5
    * **Spring Web:** Para o desenvolvimento das APIs REST.
    * **Spring Data JPA:** Para facilitar a interação com o banco de dados e o mapeamento objeto-relacional (ORM).
    * **Spring Boot Starter Validation:** Para validar os dados enviados nas requisições.
    * **Spring Boot Starter Actuator:** Para monitoramento da aplicação.
    * **Spring Boot DevTools:** Para facilitar o desenvolvimento.
* **Banco de Dados:** PostgreSQL (configurado para uso em tempo de execução).
* **Mapeamento Objeto-Relacional:** MapStruct para conversão entre DTOs e Entidades.
* **Geração de Boilerplate:** Lombok para reduzir código repetitivo.
* **Documentação da API:** Springdoc OpenAPI (Swagger UI).
* **Build e Gerenciamento de Dependências:** Apache Maven.

### Frontend (beautyhub-frontend)

* **Framework Principal:** Angular 19.2.0 (especificamente `@angular/core`, `@angular/common`, etc. na versão `^19.2.0`).
* **Linguagem:** TypeScript ~5.7.2.
* **Gerenciamento de Estado (Reativo):** RxJS ~7.8.0.
* **Ferramenta de Linha de Comando:** Angular CLI 19.2.13.
* **Testes Unitários:** Karma (~6.4.0) e Jasmine (~5.6.0).

---

## O que você precisa para rodar o projeto? 📋

### Backend

* Java JDK 17 ou uma versão mais recente.
* Um servidor PostgreSQL instalado e rodando.
* Apache Maven.
* Sua IDE preferida (IntelliJ IDEA, Eclipse, VS Code, etc.).

### Frontend

* Node.js (que inclui npm).
* Angular CLI (versão 19.2.13 ou compatível instalado globalmente ou via npx).

---

## Colocando para funcionar 🚀

### Backend (beautyhub-api)

1.  **Clone o Repositório:**
    ```bash
    git clone <url-do-repositorio-do-beautyhub-api>
    cd beautyhub-api
    ```
2.  **Configure o Banco de Dados:**
    * Verifique se o seu servidor PostgreSQL está ativo.
    * Crie um banco de dados com o nome `beautyhub`. Se preferir usar outro nome, porta ou credenciais, ajuste as propriedades no arquivo `src/main/resources/application.properties`.
        ```properties
        spring.datasource.url=jdbc:postgresql://localhost:5432/beautyhub
        spring.datasource.username=seu_usuario_postgres
        spring.datasource.password=sua_senha_postgres
        ```
    * O Hibernate (`spring.jpa.hibernate.ddl-auto=update`) cuidará de criar/atualizar a estrutura do banco (tabelas, colunas, etc.) automaticamente com base nas entidades.
3.  **Compile o Projeto:** Use o Maven para compilar o código e baixar as dependências:
    ```bash
    mvn clean install
    ```
4.  **Execute a Aplicação:** Com o projeto compilado, você pode iniciá-lo com o comando:
    ```bash
    mvn spring-boot:run
    ```
    * Outra opção é executar a classe `BeautyhubApiApplication.java` diretamente pela sua IDE.
    * Após esses passos, a API estará rodando, geralmente no endereço `http://localhost:8080`.
    * A documentação Swagger UI estará disponível em `http://localhost:8080/swagger-ui.html` (ou o path configurado pelo Springdoc).

### Frontend (beautyhub-frontend)

1.  **Navegue até o diretório do frontend:**
    ```bash
    cd beautyhub-frontend 
    ```
    (Este diretório está dentro do projeto `beautyhub-api` clonado).
2.  **Instale as Dependências:**
    ```bash
    npm install
    ```
    (Comando inferido, padrão para projetos Node.js com `package.json`).
3.  **Execute o Servidor de Desenvolvimento:**
    ```bash
    ng serve
    ```
   
    Ou utilize o script `start` do `package.json`:
    ```bash
    npm start
    ```
4.  **Acesse no Navegador:** Abra seu navegador e acesse `http://localhost:4200/`. A aplicação recarregará automaticamente se você alterar algum dos arquivos de origem.

---

## Endpoints da API: Onde tudo acontece 🌐

A API do BeautyHub oferece os seguintes endpoints principais para gerenciamento de produtos, todos sob o base path `/products`:

* `GET /`: Lista todos os produtos.
    * Permite filtrar por nome: `GET /?name=nomeDoProduto`
    * Permite filtrar por categoria: `GET /?category=categoriaDoProduto`
    * Permite filtrar por nome E categoria: `GET /?name=nomeDoProduto&category=categoriaDoProduto`
* `POST /`: Adiciona um novo produto.
    * **Corpo da requisição**: Objeto JSON com os dados do `ProductDTO` (`name`, `category`, `imageUrl`, `price`, `rating`).
* `PUT /{id}`: Atualiza um produto existente pelo seu `id`.
    * **Corpo da requisição**: Objeto JSON com os dados do `ProductDTO` a serem atualizados.
* `DELETE /{id}`: Remove um produto pelo seu `id`.

---

## Gerenciamento do Banco de Dados 🐘

A estrutura do banco de dados (tabelas, colunas, etc.) é gerenciada automaticamente pelo Hibernate com base nas entidades Java (`com.julia.beautyhub.model.Product`). A configuração `spring.jpa.hibernate.ddl-auto=update` no arquivo `application.properties` permite que o Hibernate atualize o schema do banco de dados conforme necessário ao iniciar a aplicação.

---

## Garantindo a Qualidade com Testes ✅

### Backend

* **Testes de Contexto:**
    * `BeautyhubApiApplicationTests.java`: Verifica se o contexto do Spring Boot carrega corretamente.
* O projeto está configurado com JUnit 5 (`spring-boot-starter-test`) e Mockito (implícito no starter de teste) para facilitar a escrita de testes unitários e de integração.

### Frontend

* **Testes Unitários:**
    * Comando para execução: `ng test`.
    * Utiliza Karma como test runner e Jasmine como framework de teste.
    * Existem arquivos de teste para os principais componentes e serviços, como `AppComponent.spec.ts`, `ProductListComponent.spec.ts`, e `ProductService.spec.ts`.

---

## Observações Importantes 📝

* **CORS:** O backend está configurado em `WebConfig.java` para aceitar requisições do frontend rodando em `http://localhost:4200`, permitindo os métodos GET, POST, PUT, DELETE e todos os headers.
* **Comunicação Frontend-Backend:** O `ProductService` no frontend está configurado para se comunicar com a API backend em `http://localhost:8080/products`.
* **Estrutura do Projeto:** O frontend (`beautyhub-frontend`) está aninhado dentro da estrutura do projeto backend (`beautyhub-api`).
* **Estilo do Código:** Recomenda-se seguir boas práticas de desenvolvimento, como o padrão Conventional Commits para mensagens de commit.
