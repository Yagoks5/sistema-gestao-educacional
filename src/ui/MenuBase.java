package ui;

import model.*;
import repository.*;
import service.*;
import java.util.Scanner;

public abstract class MenuBase {
    protected Scanner scanner;
    protected UsuarioRepository usuarioRepository;
    protected CursoRepository cursoRepository;
    protected TurmaRepository turmaRepository;
    protected UsuarioService usuarioService;
    protected CursoService cursoService;
    protected TurmaService turmaService;
    protected AvaliacaoService avaliacaoService;
    protected RelatorioService relatorioService;
    protected Usuario usuarioLogado;
    protected MenuUI menuUI;

    public MenuBase(Usuario usuarioLogado, MenuUI menuUI) {
        this.menuUI = menuUI;
        this.scanner = menuUI.getScanner();
        this.usuarioRepository = menuUI.getUsuarioRepository();
        this.cursoRepository = menuUI.getCursoRepository();
        this.turmaRepository = menuUI.getTurmaRepository();
        this.usuarioService = menuUI.getUsuarioService();
        this.cursoService = menuUI.getCursoService();
        this.turmaService = menuUI.getTurmaService();
        this.avaliacaoService = menuUI.getAvaliacaoService();
        this.relatorioService = menuUI.getRelatorioService();
        this.usuarioLogado = usuarioLogado;
    }

    // ========== MÉTODOS UTILITÁRIOS COMUNS ==========

    protected void cadastrarAluno() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           CADASTRAR ALUNO");
        System.out.println("=".repeat(50));

        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Login: ");
            String login = scanner.nextLine();
            System.out.print("Senha: ");
            String senha = scanner.nextLine();
            System.out.print("Matrícula: ");
            String matricula = scanner.nextLine();

            System.out.println("\n📚 Cursos disponíveis:");
            cursoService.listarTodosCursos();
            System.out.print("Código do curso: ");
            String codigoCurso = scanner.nextLine();

            Curso curso = cursoService.buscarCursoPorCodigo(codigoCurso);
            if (curso != null) {
                usuarioService.cadastrarAluno(nome, login, senha, matricula, curso);
            } else {
                System.out.println("❌ Curso não encontrado!");
            }
        } catch (Exception e) {
            System.out.println("❌ Erro ao cadastrar aluno: " + e.getMessage());
        }
    }

    protected void cadastrarProfessor() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           CADASTRAR PROFESSOR");
        System.out.println("=".repeat(50));

        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Login: ");
            String login = scanner.nextLine();
            System.out.print("Senha: ");
            String senha = scanner.nextLine();
            System.out.print("Especialidade: ");
            String especialidade = scanner.nextLine();
            System.out.print("Registro: ");
            String registro = scanner.nextLine();

            usuarioService.cadastrarProfessor(nome, login, senha, especialidade, registro);
        } catch (Exception e) {
            System.out.println("❌ Erro ao cadastrar professor: " + e.getMessage());
        }
    }

    protected void cadastrarCurso() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           CADASTRAR CURSO");
        System.out.println("=".repeat(50));

        try {
            System.out.print("Nome do curso: ");
            String nome = scanner.nextLine();
            System.out.print("Código do curso: ");
            String codigo = scanner.nextLine();
            System.out.print("Carga horária: ");
            int cargaHoraria = scanner.nextInt();
            scanner.nextLine();

            System.out.println("\n1. Curso Presencial");
            System.out.println("2. Curso EAD");
            System.out.print("Escolha o tipo: ");
            int tipo = scanner.nextInt();
            scanner.nextLine();

            if (tipo == 1) {
                System.out.print("Sala de aula: ");
                String sala = scanner.nextLine();
                cursoService.cadastrarCursoPresencial(nome, codigo, cargaHoraria, sala);
            } else if (tipo == 2) {
                System.out.print("Plataforma virtual: ");
                String plataforma = scanner.nextLine();
                cursoService.cadastrarCursoEAD(nome, codigo, cargaHoraria, plataforma);
            } else {
                System.out.println("❌ Tipo inválido!");
            }
        } catch (Exception e) {
            System.out.println("❌ Erro ao cadastrar curso: " + e.getMessage());
        }
    }

    protected void criarTurma() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           CRIAR TURMA");
        System.out.println("=".repeat(50));

        try {
            System.out.print("Código da turma: ");
            String codigo = scanner.nextLine();

            System.out.println("\n👨‍🏫 Professores disponíveis:");
            for (Professor prof : usuarioService.listarProfessores()) {
                System.out.println("  - " + prof.getNome() + " (" + prof.getLogin() + ")");
            }
            System.out.print("Login do professor: ");
            String loginProfessor = scanner.nextLine();
            Professor professor = (Professor) usuarioService.buscarPorLogin(loginProfessor);

            if (professor == null) {
                System.out.println("❌ Professor não encontrado!");
                return;
            }

            System.out.println("\n📚 Cursos disponíveis:");
            cursoService.listarTodosCursos();
            System.out.print("Código do curso: ");
            String codigoCurso = scanner.nextLine();
            Curso curso = cursoService.buscarCursoPorCodigo(codigoCurso);

            if (curso == null) {
                System.out.println("❌ Curso não encontrado!");
                return;
            }

            turmaService.criarTurma(codigo, professor, curso);
            System.out.println("✅ Turma " + codigo + " criada com sucesso!");
        } catch (Exception e) {
            System.out.println("❌ Erro ao criar turma: " + e.getMessage());
        }
    }

    protected void matricularAlunoTurma() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("        MATRICULAR ALUNO EM TURMA");
        System.out.println("=".repeat(50));

        try {
            System.out.println("\n📋 Turmas disponíveis:");
            turmaService.listarTurmas();

            System.out.print("Código da turma: ");
            String codigoTurma = scanner.nextLine();

            System.out.println("\n👥 Alunos disponíveis:");
            for (Aluno aluno : usuarioService.listarAlunos()) {
                System.out.println("  - " + aluno.getNome() + " (" + aluno.getLogin() + ")");
            }
            System.out.print("Login do aluno: ");
            String loginAluno = scanner.nextLine();

            Aluno aluno = (Aluno) usuarioService.buscarPorLogin(loginAluno);
            if (aluno != null) {
                turmaService.matricularAluno(codigoTurma, aluno);
            } else {
                System.out.println("❌ Aluno não encontrado!");
            }
        } catch (Exception e) {
            System.out.println("❌ Erro ao matricular aluno: " + e.getMessage());
        }
    }

    protected void registrarAvaliacaoComNota() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("       REGISTRAR AVALIAÇÃO COM NOTA");
        System.out.println("=".repeat(50));

        try {
            System.out.println("\n👥 Alunos cadastrados:");
            for (Aluno aluno : usuarioService.listarAlunos()) {
                System.out.println("  - " + aluno.getNome() + " (" + aluno.getLogin() + ")");
            }

            System.out.print("Login do aluno: ");
            String loginAluno = scanner.nextLine();
            System.out.print("Descrição da avaliação: ");
            String descricao = scanner.nextLine();
            System.out.print("Nota (0-10): ");
            double nota = scanner.nextDouble();
            scanner.nextLine();

            avaliacaoService.registrarAvaliacao(loginAluno, descricao, nota);
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Entrada inválida!");
            scanner.nextLine();
        }
    }

    protected void registrarAvaliacaoSemNota() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("      REGISTRAR AVALIAÇÃO SEM NOTA");
        System.out.println("=".repeat(50));

        try {
            System.out.println("\n👥 Alunos cadastrados:");
            for (Aluno aluno : usuarioService.listarAlunos()) {
                System.out.println("  - " + aluno.getNome() + " (" + aluno.getLogin() + ")");
            }

            System.out.print("Login do aluno: ");
            String loginAluno = scanner.nextLine();
            System.out.print("Descrição da avaliação: ");
            String descricao = scanner.nextLine();

            avaliacaoService.registrarAvaliacaoSemNota(loginAluno, descricao);
        } catch (Exception e) {
            System.out.println("❌ Erro ao registrar avaliação: " + e.getMessage());
        }
    }

    protected void atribuirNotaAvaliacao() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("        ATRIBUIR NOTA A AVALIAÇÃO");
        System.out.println("=".repeat(50));

        try {
            System.out.println("\n👥 Alunos cadastrados:");
            for (Aluno aluno : usuarioService.listarAlunos()) {
                System.out.println("  - " + aluno.getNome() + " (" + aluno.getLogin() + ")");
            }

            System.out.print("Login do aluno: ");
            String loginAluno = scanner.nextLine();
            System.out.print("Descrição da avaliação: ");
            String descricaoAvaliacao = scanner.nextLine();
            System.out.print("Nota (0-10): ");
            double nota = scanner.nextDouble();
            scanner.nextLine();

            avaliacaoService.atribuirNota(loginAluno, descricaoAvaliacao, nota);
        } catch (Exception e) {
            System.out.println("❌ Erro: " + e.getMessage());
            scanner.nextLine();
        }
    }

    protected void verAvaliacoesAluno() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("        VER AVALIAÇÕES DO ALUNO");
        System.out.println("=".repeat(50));

        System.out.println("\n👥 Alunos cadastrados:");
        for (Aluno aluno : usuarioService.listarAlunos()) {
            System.out.println("  - " + aluno.getNome() + " (" + aluno.getLogin() + ")");
        }

        System.out.print("Login do aluno: ");
        String loginAluno = scanner.nextLine();

        avaliacaoService.exibirAvaliacoesAluno(loginAluno);
    }

    public abstract void exibirMenu();
}