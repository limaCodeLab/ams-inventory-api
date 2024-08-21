# Inventory Service API 
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/limaCodeLab/ams-inventory-api/blob/master/LICENSE) 

# Sobre o serviço 

Web Service: https://auto-mechanic-system.onrender.com/inventory-api/

**"Observação: Como o serviço está hospedado em uma versão gratuita do Render, a inicialização pode levar alguns instantes. Se não aparecer, é possível que tenha sido excluído automaticamente pelo Render após 90 dias. Você pode testar o serviço localmente."**

O serviço Inventory é uma API RESTful desenvolvida para facilitar o gerenciamento de estoque. Ele oferece as seguintes funcionalidades:
- Cadastro de produtos, categorias e fornecedores
- Atualização de quantidades e informações
- Consultas de produtos, categorias e fornecedores
- Remoção de produtos, categorias e fornecedores
- Registro de transações de entrada e saída
- Validação de dados
- Segurança e autorização por usuários
- Auditoria e geração de logs
- Garantia de integridade no controle de estoque

## Regras de negócio 
As regras de negócio do serviço Inventory estão detalhadas na Wiki.

Link: https://github.com/limaCodeLab/ams-inventory-api/wiki/Regras-de-Neg%C3%B3cio-do-Servi%C3%A7o

## Documentações técnicas 
A respectiva documentação também está disponível na Wiki.

Link: 

SWAGGER API Link : 

## Modelo conceitual
![Modelo Conceitual](EM CONSTRUCAO)

# Tecnologias utilizadas

## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven

## Implantação em produção
- Back end: Microsoft Azure
- Banco de dados: Postgresql

## Testes
- Testes Unitarios: JUnit 5 + Mockito
- Teste Integracao: Spring Boot Test
- Teste API: RestAssured e Postman

## Integração contínua
- GitHub Actions
- Docker

## Documentações
- Swagger API
- Javadoc
- GitHub Wiki
- Lucidchart UML

# Como executar o serviço In-Local

Pré-requisitos: Java 21, PostgreSQL

Variável  de Ambiente: SPRING_PROFILE

Valores: 
- test (Para execução com banco em memória H2 Console)
- dev (Para execução com banco relacional PostgreeSQL)

```bash
# clonar repositório
git clone https://github.com/limaCodeLab/ams-inventory-api.git

# entrar na pasta do projeto back end
cd ams-inventory-api

# executar o projeto
mvn spring-boot:run
```

# Autor

Alan Lima 😀
<p>
  <a href="https://www.linkedin.com/in/alaanlimaa/" target="_blank"><img alt="LinkedIn" src="https://img.shields.io/badge/linkedin-%230077B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white" /></a> 
  <a href="https://www.instagram.com/alaanlimaa/" target="_blank"><img alt="Instagram" src="https://img.shields.io/badge/Instagram-%23E4405F?logo=Instagram&logoColor=white&style=for-the-badge" /></a>
</p>

# Como Contribuir

Sua contribuição é muito bem-vinda! Siga estas etapas para contribuir com o projeto:

1. Faça um fork deste repositório.
2. Crie uma nova branch para sua funcionalidade (git checkout -b feature/nome-da-feature).
3. Faça commit das suas alterações (git commit -m 'Adicionando nova feature').
4. Envie para a branch principal (git push origin feature/nome-da-feature).
5. Abra um Pull Request detalhando suas mudanças.
