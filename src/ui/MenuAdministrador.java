package ui;

import model.Administrador;

public class MenuAdministrador extends MenuBase {

    public MenuAdministrador(Administrador administrador, MenuUI menuUI) {
        super(administrador, menuUI);
    }

    @Override
    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("      🔐 MENU ADMINISTRADOR - " + usuarioLogado.getNome());
            System.out.println("=".repeat(50));
            System.out.println("1. 👥 Gerenciar Usuários");
            System.out.println("2. 📚 Gerenciar Cursos");
            System.out.println("3. 📋 Gerenciar Turmas");
            System.out.println("4. 📊 Gerar Relatórios");
            System.out.println("5. ✏️  Avaliações");
            System.out.println("6. 🚪 Logout");
            System.out.print("\nEscolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> menuGerenciarUsuarios();
                    case 2 -> menuGerenciarCursos();
                    case 3 -> menuGerenciarTurmas();
                    case 4 -> menuRelatorios();
                    case 5 -> menuAvaliacoes();
                    case 6 -> System.out.println("\n✅ Logout realizado com sucesso!");
                    default -> System.out.println("❌ Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("❌ Entrada inválida!");
                scanner.nextLine();
                opcao = 0;
            }
        } while (opcao != 6);
    }

    private void menuGerenciarUsuarios() {
        int opcao;
        do {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("           GERENCIAR USUÁRIOS");
            System.out.println("=".repeat(50));
            System.out.println("1. ➕ Cadastrar Aluno");
            System.out.println("2. ➕ Cadastrar Professor");
            System.out.println("3. ➕ Cadastrar Administrador");
            System.out.println("4. 📋 Listar Todos Usuários");
            System.out.println("5. 👥 Listar Alunos");
            System.out.println("6. 👨‍🏫 Listar Professores");
            System.out.println("7. ↩️  Voltar");
            System.out.print("\nEscolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> cadastrarAluno();
                    case 2 -> cadastrarProfessor();
                    case 3 -> cadastrarAdministrador();
                    case 4 -> usuarioService.listarTodosUsuarios();
                    case 5 -> listarAlunos();
                    case 6 -> listarProfessores();
                    case 7 -> System.out.println("↩️  Voltando ao menu anterior...");
                    default -> System.out.println("❌ Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("❌ Entrada inválida!");
                scanner.nextLine();
                opcao = 0;
            }
        } while (opcao != 7);
    }

    private void cadastrarAdministrador() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("         CADASTRAR ADMINISTRADOR");
        System.out.println("=".repeat(50));

        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Login: ");
            String login = scanner.nextLine();
            System.out.print("Senha: ");
            String senha = scanner.nextLine();
            System.out.print("Cargo: ");
            String cargo = scanner.nextLine();

            usuarioService.cadastrarAdministrador(nome, login, senha, cargo);
        } catch (Exception e) {
            System.out.println("❌ Erro ao cadastrar administrador: " + e.getMessage());
        }
    }

    private void listarAlunos() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("             ALUNOS CADASTRADOS");
        System.out.println("=".repeat(50));
        var alunos = usuarioService.listarAlunos();
        if (alunos.isEmpty()) {
            System.out.println("📭 Nenhum aluno cadastrado!");
        } else {
            alunos.forEach(aluno -> {
                System.out.println("-".repeat(50));
                aluno.exibirAluno();
            });
        }
    }

    private void listarProfessores() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("            PROFESSORES CADASTRADOS");
        System.out.println("=".repeat(50));
        var professores = usuarioService.listarProfessores();
        if (professores.isEmpty()) {
            System.out.println("📭 Nenhum professor cadastrado!");
        } else {
            professores.forEach(professor -> {
                System.out.println("-".repeat(50));
                professor.exibirProfessor();
            });
        }
    }

    private void menuGerenciarCursos() {
        int opcao;
        do {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("           GERENCIAR CURSOS");
            System.out.println("=".repeat(50));
            System.out.println("1. ➕ Cadastrar Curso");
            System.out.println("2. 📚 Listar Todos os Cursos");
            System.out.println("3. 🔍 Buscar Curso por Código");
            System.out.println("4. ↩️  Voltar");
            System.out.print("\nEscolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> cadastrarCurso();
                    case 2 -> cursoService.listarTodosCursos();
                    case 3 -> buscarCursoPorCodigo();
                    case 4 -> System.out.println("↩️  Voltando ao menu anterior...");
                    default -> System.out.println("❌ Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("❌ Entrada inválida!");
                scanner.nextLine();
                opcao = 0;
            }
        } while (opcao != 4);
    }

    private void buscarCursoPorCodigo() {
        System.out.print("\n🔍 Digite o código do curso: ");
        String codigo = scanner.nextLine();
        var curso = cursoService.buscarCursoPorCodigo(codigo);
        if (curso != null) {
            System.out.println("\n" + "=".repeat(50));
            curso.exibirCurso();
            System.out.println("=".repeat(50));
        }
    }

    private void menuGerenciarTurmas() {
        int opcao;
        do {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("           GERENCIAR TURMAS");
            System.out.println("=".repeat(50));
            System.out.println("1. ➕ Criar Turma");
            System.out.println("2. 👤 Matricular Aluno em Turma");
            System.out.println("3. 📋 Listar Todas as Turmas");
            System.out.println("4. ↩️  Voltar");
            System.out.print("\nEscolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> criarTurma();
                    case 2 -> matricularAlunoTurma();
                    case 3 -> turmaService.listarTurmas();
                    case 4 -> System.out.println("↩️  Voltando ao menu anterior...");
                    default -> System.out.println("❌ Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("❌ Entrada inválida!");
                scanner.nextLine();
                opcao = 0;
            }
        } while (opcao != 4);
    }

    private void menuRelatorios() {
        int opcao;
        do {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("           GERAR RELATÓRIOS");
            System.out.println("=".repeat(50));
            System.out.println("1. 👥 Relatório de Alunos");
            System.out.println("2. 👨‍🏫 Relatório de Professores");
            System.out.println("3. 📚 Relatório de Cursos");
            System.out.println("4. 📊 Relatório Completo");
            System.out.println("5. ↩️  Voltar");
            System.out.print("\nEscolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> relatorioService.gerarRelatorioAlunos();
                    case 2 -> relatorioService.gerarRelatorioProfessores();
                    case 3 -> relatorioService.gerarRelatorioCursos();
                    case 4 -> relatorioService.gerarTodosRelatorios();
                    case 5 -> System.out.println("↩️  Voltando ao menu anterior...");
                    default -> System.out.println("❌ Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("❌ Entrada inválida!");
                scanner.nextLine();
                opcao = 0;
            }
        } while (opcao != 5);
    }

    private void menuAvaliacoes() {
        int opcao;
        do {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("           GERENCIAR AVALIAÇÕES");
            System.out.println("=".repeat(50));
            System.out.println("1. ➕ Registrar Avaliação com Nota");
            System.out.println("2. ➕ Registrar Avaliação sem Nota");
            System.out.println("3. 📝 Atribuir Nota a Avaliação");
            System.out.println("4. 👁️  Ver Avaliações do Aluno");
            System.out.println("5. ↩️  Voltar");
            System.out.print("\nEscolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> registrarAvaliacaoComNota();
                    case 2 -> registrarAvaliacaoSemNota();
                    case 3 -> atribuirNotaAvaliacao();
                    case 4 -> verAvaliacoesAluno();
                    case 5 -> System.out.println("↩️  Voltando ao menu anterior...");
                    default -> System.out.println("❌ Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("❌ Entrada inválida!");
                scanner.nextLine();
                opcao = 0;
            }
        } while (opcao != 5);
    }
}