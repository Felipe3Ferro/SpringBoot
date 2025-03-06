# 💡 Estudo sobre Spring Boot com API do Trello

Este repositório contém um estudo prático sobre como utilizar **Spring Boot** para consumir a API do **Trello** e criar exemplos funcionais de interação com a plataforma. O objetivo é entender como realizar **requisições HTTP**, manipular **JSON**, e gerenciar **autenticação via API Key e Token**.

## 🚀 Tecnologias Utilizadas

- **Spring Boot** - Framework para desenvolvimento de aplicações Java.
- **Spring Web** - Módulo para interação com APIs REST.
- **RestTemplate / WebClient** - Ferramentas para fazer requisições HTTP.
- **Jackson** - Biblioteca para serialização e desserialização de JSON.
- **API do Trello** - Plataforma de gerenciamento de tarefas.

## 💡 Funcionalidades Implementadas

- **Autenticação** com API Key e Token do Trello.
- **Criação de quadros** automaticamente.
- **Adicionação de listas e cards em um quadro existente.**
- **Obtenção de informações** sobre quadros, listas e cards.

## 📚 Como Configurar o Projeto

### 🔹 **Requisitos**
Antes de iniciar, garanta que você tem instalado:
- **Java 17+**
- **Maven**
- **Conta no Trello** para obter API Key e Token

### 🔹 **Passos para Executar**
1. Clone este repositório:
   ```bash
   git clone https://github.com/seuusuario/springboot-trello-api.git
   cd springboot-trello-api
   ```
2. Configure as credenciais no **application.properties**:
   ```properties
   trello.api.key=SEU_API_KEY
   trello.api.token=SEU_TOKEN
   trello.board.name=Meu Quadro Spring Boot
   ```
3. Compile e execute o projeto:
   ```bash
   mvn spring-boot:run
   ```
4. Acesse os endpoints no navegador ou via **Postman**.

Dúvidas ou sugestões? Abra uma **issue** ou contribua com o repositório! 🚀
