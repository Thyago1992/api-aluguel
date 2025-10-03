# 🏠 Sistema de Gestão de Aluguéis

API REST para gerenciamento de aluguéis de imóveis, desenvolvida com Spring Boot 3.3.4 e Java 17.

## 🎯 Sobre o Projeto

Sistema completo para gerenciamento de aluguéis de imóveis que permite:

* ✅ Cadastro de imóveis e inquilinos
* ✅ Registro de aluguéis com controle de vencimento
* ✅ Listagem de aluguéis em atraso
* ✅ Marcação de aluguéis como pagos
* ✅ Validação de dados e regras de negócio

## ✨ Funcionalidades

### Imóveis

* ✅ Cadastro de imóveis com descrição e endereço
* ✅ Validação de campos obrigatórios

### Inquilinos

* ✅ Cadastro de inquilinos com nome e email
* ✅ Validação de email único
* ✅ Email opcional

### Aluguéis

* ✅ Registro de novos aluguéis
* ✅ Verificação de imóveis já alugados
* ✅ Listagem de aluguéis atrasados com cálculo automático de dias
* ✅ Marcação de aluguéis como pagos
* ✅ Suporte a aluguéis sem inquilino definido

## 🛠 Tecnologias Utilizadas

### Backend

* ✅ Java 17
* ✅ Spring Boot 3.3.4


* ✅ Spring Web
* ✅ Spring Data JPA
* ✅ Spring Validation
* ✅ Spring DevTools


* ✅ Hibernate (JPA Provider)
* ✅ Lombok - Redução de boilerplate
* ✅ ModelMapper 3.2.0 - Mapeamento de objetos

### Banco de Dados

* ✅ H2 Database (em memória)
* ✅ Console H2 habilitado

### Documentação

* ✅ SpringDoc OpenAPI 2.6.0 (Swagger UI)

### Build

* ✅ Maven

## 🏗 Arquitetura

O projeto segue uma arquitetura em camadas:

br.com.fuctura.gestaoalugueis\
├── config/              # Configurações (CORS, ModelMapper)\
├── controller/          # Endpoints REST\
│   └── interfaces/      # Contratos dos controllers\
├── dto/                 # Data Transfer Objects\
├── exception/           # Exceções customizadas e handlers\
├── model/               # Entidades JPA\
├── repository/          # Repositórios Spring Data\
├── service/             # Lógica de negócio\
└── validation/          # Validações customizadas

## 🚀 Instalação

### 1. Clone o repositório

```bash
git clone https://github.com/Thyago1992/api-aluguel.git
cd api-aluguel
```

### 2. Compile o projeto

```bash
mvn clean install
```

### 3. Execute a aplicação

```bash
mvn spring-boot:run
```
Ou execute a classe principal:

```bash
java -jar target/api-aluguel-0.0.1-SNAPSHOT.jar
```
A aplicação estará disponível em: http://localhost:8080

## ⚙ Configuração

### application.properties

O arquivo src/main/resources/application.properties contém:

```properties
# H2 Database
spring.datasource.url=jdbc:h2:mem:alugueldb
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA/Hibernate
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
spring.jpa.defer-datasource-initialization=true
spring.sql.init.mode=always
```

## Console H2

Acesse o console do banco de dados em: http://localhost:8080/h2-console

### Credenciais:

* JDBC URL: jdbc:h2:mem:alugueldb
* Username: sa
* Password: (deixe em branco)

## 🔌 Endpoints da API

### Imóveis

#### POST /imoveis

Cadastra um novo imóvel.

#### Request Body:
```json
{
  "descricao": "Apartamento 2 quartos centro",
  "endereco": "Rua das Flores, 123 - Centro"
}
```
#### Response: 201 Created

```json
{
  "id": 1,
  "descricao": "Apartamento 2 quartos centro",
  "endereco": "Rua das Flores, 123 - Centro"
}
```

### Inquilinos

#### POST /inquilinos

Cadastra um novo inquilino.

#### Request Body:

```json
{
  "nome": "João Silva Santos",
  "email": "joao.silva@email.com"
}
```

#### Response: 201 Created

```json
{
  "id": 1,
  "nome": "João Silva Santos",
  "email": "joao.silva@email.com"
}
```

### Aluguéis

#### POST /alugueis

Registra um novo aluguel.

#### Request Body:

```json
{
  "imovel": {
    "id": 1
  },
  "inquilino": {
    "id": 1
  },
  "valor": 1500.00,
  "dataVencimento": "2025-10-10",
  "pago": false
}
```

#### Response: 201 Created

```json
{
  "id": 1,
  "imovel": {
    "id": 1,
    "descricao": "Apartamento 2 quartos centro",
    "endereco": "Rua das Flores, 123 - Centro"
  },
  "inquilino": {
    "id": 1,
    "nome": "João Silva Santos",
    "email": "joao.silva@email.com"
  },
  "valor": 1500.00,
  "dataVencimento": "2025-10-10",
  "pago": false
}
```

#### GET /alugueis/atrasados

Lista todos os aluguéis em atraso.

#### Response: 200 OK

```json
[
  {
    "id": 1,
    "inquilino": "João Silva Santos",
    "imovel": "Apartamento 2 quartos centro",
    "valor": 1500.00,
    "diasEmAtraso": 15
  }
]
```
#### PUT /alugueis/{id}/marcar-pago

Marca um aluguel como pago.

#### Response: 200 OK

```json
"Aluguel ID 1 marcado como pago com sucesso!"
```

## 🗄 Estrutura do Banco de Dados

### Tabela: imoveis

| Campo    | Tipo    | Restrições               |
|----------|---------|--------------------------|
| id       | BIGINT  | PK, AUTO_INCREMENT       |
| descricao| VARCHAR | NOT BLANK                |
| endereco | VARCHAR | NOT BLANK (permite NULL) |

### Tabela: inquilinos

| Campo | Tipo    | Restrições           |
|-------|---------|----------------------|
| id    | BIGINT  | PK, AUTO_INCREMENT   |
| nome  | VARCHAR | NOT BLANK            |
| email | VARCHAR | UNIQUE, permite NULL |

### Tabela: alugueis

| Campo         | Tipo      | Restrições                       |
|---------------|-----------|----------------------------------|
| id            | BIGINT    | PK, AUTO_INCREMENT               |
| imovel_id     | BIGINT    | FK (imoveis.id), NOT NULL        |
| inquilino_id  | BIGINT    | FK (inquilinos.id), permite NULL |
| valor         | DECIMAL   | NOT NULL                         |
| data_vencimento| DATE     | -                                |
| pago          | BOOLEAN   | NOT NULL                         |

### Relacionamentos

**alugueis.imovel_id → imoveis.id (N:1)\
alugueis.inquilino_id → inquilinos.id (N:1, opcional)**

## ✔ Validações e Regras de Negócio

### Imóveis

* ✅ Descrição é obrigatória
* ✅ Endereço é opcional

### Inquilinos

* ✅ Nome é obrigatório
* ✅ Email deve ser válido (formato)
* ✅ Email deve ser único no sistema
* ✅ Email é opcional (pode ser null)

### Aluguéis

* ✅ Imóvel é obrigatório
* ✅ Valor deve ser maior ou igual a zero
* ✅ Não pode haver dois aluguéis ativos para o mesmo imóvel
* ✅ Inquilino é opcional (permite aluguéis sem inquilino definido)
* ✅ Data de vencimento é opcional
* ✅ Status "pago" padrão é false

### Validação Customizada: @NotBlankButNullable

Permite valores null, mas não permite strings vazias ou apenas com espaços:

* ✅ null → válido
* ✅ "Rua das Flores, 123 - Centro" → válido
* ❌ "" → inválido
* ❌ "   " → inválido

## 🛡 Tratamento de Exceções

A API possui tratamento centralizado de exceções com respostas padronizadas:
Exceções Customizadas

| Exceção              | Status | Descrição                    |
|---------------------|--------|------------------------------|
| ResourceNotFoundException| 404    | Recurso não encontrado       |
| DuplicateResourceException| 409    | Recurso duplicado            |
| BusinessException   | 400    | Violação de regra de negócio |
| MethodArgumentNotValidException| 400    | Erro de validação de campos  |
| ConstraintViolationException| 400    | Violação de restrição         |
| DataIntegrityViolationException| 409    | Violação de integridade       |
| Exception           | 500    | Erro interno do servidor      |

### Formato de Resposta de Erro

```json
{
  "timestamp": "2025-10-03T14:30:00",
  "status": 404,
  "error": "Not Found",
  "message": "Aluguel com ID 999 não encontrado",
  "path": "/alugueis/999"
}
```
### Erro de Validação (com detalhes)

```json
{
  "timestamp": "2025-10-03T14:30:00",
  "status": 400,
  "error": "Validation Error",
  "message": "Erro de validação nos campos",
  "path": "/inquilinos",
  "errors": [
    {
      "field": "email",
      "message": "Email deve ser válido"
    },
    {
      "field": "nome",
      "message": "Nome é obrigatório"
    }
  ]
}
```

## 📚 Documentação Swagger

A API possui documentação interativa via Swagger UI.\
**Acesso**: http://localhost:8080/swagger-ui/index.html 

A documentação inclui:

* Descrição de todos os endpoints
* Modelos de request/response
* Códigos de status HTTP
* Possibilidade de testar endpoints diretamente

## 💡 Exemplos de Uso

### 1. Cadastrar um Imóvel

```bash
curl -X POST http://localhost:8080/imoveis \
  -H "Content-Type: application/json" \
  -d '{
    "descricao": "Casa 3 quartos",
    "endereco": "Av. Principal, 456"
  }'
```
### 2. Cadastrar um Inquilino

```bash
curl -X POST http://localhost:8080/inquilinos \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Maria Silva",
    "email": "maria@email.com"
  }'
``` 
### 3. Registrar um Aluguel

```bash
curl -X POST http://localhost:8080/alugueis \
  -H "Content-Type: application/json" \
  -d '{
    "imovel": {"id": 1},
    "inquilino": {"id": 1},
    "valor": 1500.00,
    "dataVencimento": "2025-11-10",
    "pago": false
  }'
```
### 4. Listar Aluguéis Atrasados

```bash
curl -X GET http://localhost:8080/alugueis/atrasados
```

### 5. Marcar Aluguel como Pago

```bash
curl -X PUT http://localhost:8080/alugueis/1/marcar-pago
```


## 📊 Dados de Exemplo

O sistema já vem com dados pré-carregados via data.sql:

* 10 imóveis cadastrados
* 10 inquilinos cadastrados
* 10 aluguéis registrados (com diferentes status)7

## 🔍 Consultas Úteis no H2

```sql
-- Ver todos os aluguéis com informações completas
SELECT a.id, i.descricao as imovel, inq.nome as inquilino, 
       a.valor, a.data_vencimento, a.pago
FROM alugueis a
LEFT JOIN imoveis i ON a.imovel_id = i.id
LEFT JOIN inquilinos inq ON a.inquilino_id = inq.id;

-- Ver aluguéis atrasados
SELECT * FROM alugueis 
WHERE pago = false 
  AND data_vencimento < CURRENT_DATE;

-- Ver imóveis disponíveis (sem aluguel ativo)
SELECT i.* FROM imoveis i
WHERE NOT EXISTS (
  SELECT 1 FROM alugueis a 
  WHERE a.imovel_id = i.id AND a.pago = false
);
```

## 📝 Licença

Este projeto foi desenvolvido para fins educacionais.

## 👥 Autores

Desenvolvido por Thyago Antonio Sampaio Valadares como projeto de aprendizado e prática.
