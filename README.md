Loja de Revistas Sunshine - Sistema de Cadastro:
Este é um projeto simples em Java sendo desenvolvido no bootcamp da deloitte para gerenciar o cadastro de clientes de uma banca de revistas. O sistema permite a entrada de dados, atualização e exclusão via console.

## 🚀 Tecnologias Utilizadas

- **Linguagem:** Java 17
- **Framework Principal:** Spring Boot v3.2.0
- **Persistência de Dados:** Spring Data JPA / Hibernate
- **Banco de Dados:** H2 Database (Em memória para ambiente de testes/homologação)
- **Servidor Web Incorporado:** Apache Tomcat 10.1
- **Gerenciador de Dependências:** Maven
- **Ambiente Cloud:** Microsoft Azure (App Services)
- **Ferramentas de Deploy:** Kudu Console / Azure Advanced Tools

---

## 📐 Arquitetura do Projeto

O projeto adota o padrão de arquitetura em camadas (MVC/Service-Repository), garantindo a separação de responsabilidades, facilidade de manutenção e alta testabilidade:

- **Controller (`@Controller`):** Camada de exposição dos endpoints HTTP e mapeamento de rotas visuais (`/view/clientes`).
- **Service (`@Service`):** Camada de regras de negócio e orquestração dos dados.
- **Repository (`@Repository`):** Interface de comunicação com o banco de dados utilizando abstrações do Spring Data JPA.

---

## 🌐 Configuração de Ambiente & Nuvem (Deploy na Azure)

Um dos grandes diferenciais deste projeto é o seu ciclo de **Deploy Contínuo em Nuvem** utilizando os serviços de computação da Azure.

### Passos de Implementação:
1. **Compilação do Artefato:** Geração do arquivo executável (`.jar`) via Maven estruturado na pasta `target`.
2. **Runtime Environment:** Configuração do ecossistema Linux/Ubuntu na Azure parametrizado nativamente para rodar com o **Java 17**.
3. **Mapeamento de Inicialização (Kudu):** Implementação do artefato renomeado estrategicamente para `app.jar` dentro do diretório raiz `/home/site/wwwroot/`.
4. **Variáveis de Ambiente:** Injeção dinâmica de propriedades de conexão de dados no painel da Azure para evitar dados sensíveis no código (*Hardcoded*):
   - `SPRING_DATASOURCE_URL`: `jdbc:h2:mem:sunshinedb`
   - `SPRING_DATASOURCE_DRIVER_CLASS_NAME`: `org.h2.Driver`

---

## 🗺️ Mapeamento de Rotas (Endpoints)

A aplicação responde nos seguintes caminhos principais após a inicialização:

- **Página Principal de Clientes:** `https://<sua-url-azure>.azurewebsites.net/view/clientes`
- **Console do Banco de Dados (H2 Console):** `https://<sua-url-azure>.azurewebsites.net/h2-console`

---
