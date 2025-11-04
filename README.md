#  Projeto JDBC - Acesso a Banco de Dados com Java

##  Objetivo do Projeto
Este projeto tem como objetivo aplicar os conceitos de **JDBC (Java Database Connectivity)** na prática, criando uma aplicação Java capaz de conectar-se a um banco de dados MySQL, realizar consultas e manipular dados de forma estruturada e segura.

---

##  Objetivos de Aprendizado
- Compreender os principais recursos da API JDBC.  
- Montar a estrutura básica de um projeto JDBC no Eclipse.  
- Implementar o **padrão DAO (Data Access Object)** manualmente.  
- Praticar a conexão, recuperação e manipulação de dados via Java.  
- Trabalhar com **transações e integridade referencial**.

---


---

## ⚙️ Tecnologias Utilizadas
- ☕ **Java SE 17+**
- 🗄️ **MySQL Server / Workbench**
- 🔌 **JDBC (Java Database Connectivity)**
- 📦 **MySQL Connector/J**
- 🧰 **Eclipse IDE**

---
##  Configuração do Ambiente

###  Instalação das ferramentas
- Instale o **MySQL Server** e o **MySQL Workbench**.  
- Baixe o **MySQL Connector/J** ([link oficial](https://dev.mysql.com/downloads/connector/j/)).

###  Criando a base de dados
```sql
CREATE DATABASE coursejdbc;
USE coursejdbc;

CREATE TABLE department (
  Id INT PRIMARY KEY AUTO_INCREMENT,
  Name VARCHAR(60) NOT NULL
);

CREATE TABLE seller (
  Id INT PRIMARY KEY AUTO_INCREMENT,
  Name VARCHAR(60) NOT NULL,
  Email VARCHAR(100) NOT NULL,
  BirthDate DATE NOT NULL,
  BaseSalary DOUBLE NOT NULL,
  DepartmentId INT NOT NULL,
  FOREIGN KEY (DepartmentId) REFERENCES department(Id)
);

INSERT INTO department (Name) VALUES
('Computers'),
('Electronics'),
('Fashion'),
('Books');
###  Principais Classes

- **DB.java** → Gerencia a conexão com o banco de dados (abrir, fechar e criar statements).
- **DbException.java** → Exceção personalizada para erros de banco.
- **DbIntegrityException.java** → Exceção específica para violação de integridade referencial.
- **ProgramSelect.java**, **ProgramInsert.java**, **ProgramUpdate.java**, **ProgramDelete.java**, **ProgramTransaction.java** → Demos práticas para cada operação JDBC (SELECT, INSERT, UPDATE, DELETE e transações).

👨‍💻 Autor

João Victor
Desenvolvedor Java | Estudante de Estrutura de Dados e JDBC
📎 GitHub: Jhon7-dev

