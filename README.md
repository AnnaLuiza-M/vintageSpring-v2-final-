[README.md](https://github.com/user-attachments/files/21698454/README.md)
# 🎵 Vintage Spring - Loja de Discos

Sistema de gerenciamento de clientes, discos e compras, desenvolvido em **Spring Boot** com **Spring Security** e controle de permissões baseado em **roles** (`ADMIN` e `CLIENTE`).

---

## 🚀 Tecnologias Utilizadas
- **Java 17**
- **Spring Boot**
- **Spring Security**
- **Spring Data JPA / Hibernate**
- **H2 Database** (ou outro configurado no `application.properties`)
- **Maven**
- **MapStruct** (mapeamento DTO ↔ Entidade)
- **IntelliJ IDEA** para desenvolvimento

---

## 📌 Funcionalidades
- **Cadastro e autenticação** de usuários (`CLIENTE` ou `ADMIN`)
- **Controle de acesso** baseado em role
- **Gerenciamento de discos**
- **Registro e listagem de compras**
- **Listagem de clientes**
- **Segurança** com Spring Security

---

## 🔑 Regras de Acesso

| Ação                                  | Permissão Necessária |
|---------------------------------------|----------------------|
| **Listar discos**                     | Público              |
| **Visualizar disco por ID**           | Público              |
| **Criar disco**                       | ADMIN                |
| **Editar disco**                      | ADMIN                |
| **Deletar disco**                     | ADMIN                |
| **Criar cliente normal** (`/cliente`) | Público              |
| **Deletar cliente**                   | ADMIN                |
| **Editar cliente**                    | ADMIN                |
| **Buscar cliente por ID**             | ADMIN                |
| **Listar cliente**                    | ADMIN                |
| **Deletar compra**                    | ADMIN                |
| **Buscar compra por ID**              | ADMIN                |
| **Criar compra**                      | CLIENTE autenticado  |
| **Listar compras**                    | ADMIN                |

---

## 📂 Estrutura do Projeto
src/
├─ main/
│ ├─ java/
│ │ └─ vintage.spring.store.vintage_spring
│ │ ├─ controller # Endpoints REST
│ │ ├─ dto # Objetos de transferência de dados
│ │ ├─ entities # Entidades JPA
│ │ ├─ mapper # Conversão DTO ↔ Entidade
│ │ ├─ repository # Interfaces JPA
│ │ ├─ security # Configuração do Spring Security
│ │ └─ service # Regras de negócio
│ └─ resources/
│ ├─ application.properties
│ └─ data.sql # (opcional) Seed inicial


---

## 🔐 Autenticação
O sistema utiliza Basic Auth.
Para acessar endpoints protegidos, envie no Authorization Header o usuário e senha cadastrados.

Authorization → Basic Auth

**Credenciais Administrador:**
- **Username:** admin@vintage.com
- **Password:** 123

**Credenciais Cliente Genérico:**
- **Username:**	cliente@vintage.com
- **Password:** 123

## 📌 Endpoints Principais
### Clientes
POST /cliente → Criar cliente normal (Público)

GET /cliente → Listar todos os clientes (ADMIN)

GET /cliente/{id} → Buscar cliente por ID (ADMIN)

PUT /cliente/{id} → Editar cliente (ADMIN)

DELETE /cliente/{id} → Remover cliente (ADMIN)

### Discos
GET /disco → Lista todos os discos (Público)

GET /disco/{id} → Buscar disco por ID (Público)

POST /disco → Criar disco (ADMIN)

PUT /disco/{id} → Editar disco (ADMIN)

DELETE /disco/{id} → Remover disco (ADMIN)

### Compras
POST /compra → Criar compra (USER autenticado e ADMIN)

GET /compra → Listar compras (ADMIN)

GET /compra/{id} → Buscar compra por ID (ADMIN)

DELETE /compra/{id} → Remover compra (ADMIN)

---

## 📃Como Executar o Projeto

Acesse este link: 

---

## ⚠️ Observações Importantes
Senha dos usuários é armazenada de forma criptografada.

Role define as permissões (USER ou ADMIN).

Compras só podem ser criadas se o usuário estiver autenticado como USER.

Usuários criados via endpoint /cliente recebem role padrão USER.

---

## 📄 Licença
Este projeto é de uso acadêmico e foi desenvolvido para fins de aprendizado.
