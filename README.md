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

## 🧩 Fase 4 – Herança e Polimorfismo
Implementadas as classes **CursoPresencial** e **CursoEAD**, que herdam de `Curso` e sobrescrevem o método `exibirCurso()` para exibir informações específicas:

- `CursoPresencial`: inclui a sala de aula.
- `CursoEAD`: inclui a plataforma virtual.

**Conceitos aplicados:**
- Herança
- Sobrescrita de métodos
- Polimorfismo

## 🔐 Fase 5 – Autenticação e Perfis (Interfaces e Abstração)
Implementados:
- **Interface `Autenticacao`** com o método `autenticar(login, senha)`.
- **Classe abstrata `Usuario`**, generalizando os atributos comuns (`nome`, `login`, `senha`).
- **Classes `Aluno`, `Professor` e `Administrador`** implementam a autenticação e exibem perfis personalizados.

Cada usuário do sistema agora possui:
- Login e senha;
- Método de autenticação;
- Perfil exibido de forma específica.

---

### ✅ Fase 6 – Relatórios e Estatísticas (Polimorfismo e Laços)
Adicionado o método **`gerarRelatorio()`** em:
- `Aluno`
- `Professor`
- `Curso`

Implementado **menu interativo** no `Main` para gerar relatórios individuais ou gerais de forma **polimórfica**.

---

### 🧱 Fase 7 – Arquitetura em Camadas (Boa Prática de Projeto)

Para tornar o sistema mais **modular, escalável e de fácil manutenção**, foi aplicada a **arquitetura em camadas**, separando as responsabilidades principais do projeto.

#### 🗂️ Estrutura de Pacotes
O projeto foi reorganizado da seguinte forma:

```
├── model
│   ├── Administrador.java
│   ├── Aluno.java
│   ├── Autenticacao.java
│   ├── Avaliacao.java
│   ├── CursoEAD.java
│   ├── Curso.java
│   ├── CursoPresencial.java
│   ├── Professor.java
│   ├── Turma.java
│   └── Usuario.java
├── repository
│   ├── CursoRepository.java
│   ├── TurmaRepository.java
│   └── UsuarioRepository.java
├── service
│   ├── AutenticacaoService.java
│   ├── RelatorioService.java
│   └── TurmaService.java
└── ui
    ├── Main.java
    └── MenuUI.java

```

#### 🔄 Integração entre as Camadas
- A camada **model** define as entidades básicas do sistema.
- A camada **repository** gerencia o armazenamento e recuperação dos dados (em memória).
- A camada **service** aplica as regras de negócio, validações e lógica de aplicação.
- A camada **ui** é responsável pela interação com o usuário (menu, relatórios, etc.).
- A classe **Main** atua como ponto central, conectando todas as camadas para execução do sistema.

#### 🎯 Benefícios
- Melhor **organização** e **separação de responsabilidades**;
- Facilita **testes unitários** e futuras expansões;
- Aproxima o projeto de uma **arquitetura MVC simplificada**, seguindo boas práticas de engenharia de software.

---


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
