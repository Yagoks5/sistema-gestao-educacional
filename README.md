# 🎓 Sistema de Gestão Educacional (SGE)

Projeto desenvolvido para a **startup EduConnect**, com o objetivo de criar um sistema orientado a objetos para gerenciamento acadêmico.

## 🧩 Descrição

O **Sistema de Gestão Educacional (SGE)** permite o cadastro e controle de alunos, professores, cursos, turmas e avaliações.  
O projeto foi desenvolvido em **Java**, seguindo boas práticas de **programação orientada a objetos (POO)**.

## 🚀 Funcionalidades (por fases)

### 🏗️ Fase 1 – Modelagem Inicial
- Criação das classes básicas: `Aluno`, `Professor` e `Curso`
- Instanciação e validação de objetos

### 🔗 Fase 2 – Estrutura Acadêmica
- Criação da classe `Turma`
- Associação entre `Professor`, `Curso` e `Aluno`
- Métodos para adicionar e remover alunos
- Exibição de resumo da turma

### 🧠 Fase 3 – Controle de Avaliações (Encapsulamento)
- Criação da classe `Avaliacao` com atributos privados `nota` e `descricao`
- Método `atribuirNota(valor)` para controlar a atribuição da nota, garantindo valores entre **0 e 10**
- Associação de avaliações aos alunos
- Exibição das avaliações e notas de cada aluno
- Aplicação de **encapsulamento e validações** para evitar manipulação direta dos dados


## 🛠️ Tecnologias Utilizadas
- **Java 17+**
- **IntelliJ IDEA**
- **Git / GitHub**

## 🧠 Conceitos Aplicados
- Classes e Objetos
- Encapsulamento
- Associações e Relacionamentos
- Validação de dados

## 📦 Como Executar
1. Clone o repositório:
   ```bash
   git clone https://github.com/YagoRonchi/sistema-gestao-educacional.git
