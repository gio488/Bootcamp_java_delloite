☀️ Cadastro de Loja - Sunshine
Este projeto é uma API REST para gerenciamento de clientes, desenvolvida com Java 25 e Spring Boot 4. O sistema foca em boas práticas de programação, aplicando princípios SOLID e garantindo a qualidade através de testes unitários.

🚀 Funcionalidades
CRUD Completo de Clientes: Cadastro, listagem, busca por ID, atualização e exclusão.

Validação de Negócio: Sistema de validação extensível para regras de CPF e outros campos.

Banco de Dados H2: Banco de dados em memória para testes rápidos e desenvolvimento.

Testes Automatizados: Cobertura de testes unitários para a camada de serviço.

🛠️ Tecnologias Utilizadas
Java 25 & Spring Boot 4

Spring Data JPA: Para persistência de dados.

JUnit 5 & Mockito: Para testes unitários e simulação de dependências.

Lombok: Para redução de código boilerplate.

Maven: Gerenciador de dependências.

📐 Arquitetura e SOLID
O projeto foi estruturado seguindo o princípio da Responsabilidade Única (SRP) e o Princípio do Aberto/Fechado (OCP):

A camada de Service utiliza uma lista de validadores (List<ValidadorCliente>).

Isso permite adicionar novas regras de validação (como validar e-mail ou CPF duplicado) apenas criando uma nova classe, sem mexer no código existente do Service.

🧪 Testes Unitários
Foram implementados testes para garantir que:

Clientes válidos sejam salvos corretamente.

Clientes com CPF inválido lancem uma RuntimeException.

A busca por IDs inexistentes seja tratada.

O fluxo de atualização e deleção funcione conforme o esperado.

🛣️ Como testar a API
Requisitos
Java 25 ou superior instalado.

Postman ou Insomnia.

Execução
Rode a classe CadastroLojaApplication.java.

A API estará disponível em http://localhost:8080/clientes.

Exemplos de Requisição (JSON)
POST /clientes

📂 Estrutura do Projeto
Plaintext
src/main/java/com/sunshine/cadastro_loja/
├── controller   # Portas de entrada da API 
├── dto          # Objetos de transferência de dados
├── model        # Entidades do banco de dados
├── repository   # Interfaces de comunicação com o banco
├── service      # Regras de negócio e validações
└── Main.java    # Interface via console 
