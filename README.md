# 📅 Agendamento API

Uma API RESTful para gerenciamento de agendamentos, desenvolvida com Java e Spring Boot.

## 🚀 Rotas da API (Endpoints)

Abaixo estão as operações disponíveis no nosso sistema (CRUD). A URL base para testes locais é `http://localhost:8080`.

| Método HTTP | Rota (URL) | Ação (CRUD) | Descrição |
| :--- | :--- | :--- | :--- |
| **POST** | `/agendamentos` | **C**reate | Cria um novo agendamento. Exige o envio de um JSON no corpo da requisição. |
| **GET** | `/agendamentos` | **R**ead | Retorna a lista completa com todos os agendamentos salvos no banco de dados. |
| **PUT** | `/agendamentos/{id}` | **U**pdate | Atualiza os dados do agendamento correspondente ao `{id}` informado na URL. Exige JSON. |
| **DELETE** | `/agendamentos/{id}` | **D**elete | Apaga permanentemente o agendamento correspondente ao `{id}` informado na URL. |

### 📄 Formato do Payload (JSON)

Para as rotas que exigem o envio de dados (**POST** e **PUT**), o corpo da requisição (Body) deve seguir exatamente esta estrutura:

```json
{
  "cliente": "Nome do Cliente",
  "servico": "Nome do Serviço",
  "dataHora": "YYYY-MM-DDTHH:MM:SS"
}