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

    public MenuBase(Usuario usuarioLogado) {
        this.scanner = new Scanner(System.in);
        this.usuarioRepository = new UsuarioRepository();
        this.cursoRepository = new CursoRepository();
        this.turmaRepository = new TurmaRepository();
        this.usuarioService = new UsuarioService(usuarioRepository);
        this.cursoService = new CursoService(cursoRepository);
        this.turmaService = new TurmaService(turmaRepository);
        this.avaliacaoService = new AvaliacaoService(usuarioRepository);
        this.relatorioService = new RelatorioService(usuarioRepository, cursoRepository);
        this.usuarioLogado = usuarioLogado;
    }

    // Métodos utilitários comuns
    protected void cadastrarAluno() {
        System.out.println("\n=== CADASTRAR ALUNO ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        System.out.println("Cursos disponíveis:");
        cursoService.listarTodosCursos();
        System.out.print("Código do curso: ");
        String codigoCurso = scanner.nextLine();

        Curso curso = cursoService.buscarCursoPorCodigo(codigoCurso);
        if (curso != null) {
            usuarioService.cadastrarAluno(nome, login, senha, matricula, curso);
        } else {
            System.out.println("❌ Curso não encontrado!");
        }
    }

    protected void cadastrarProfessor() {
        System.out.println("\n=== CADASTRAR PROFESSOR ===");
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
    }

    protected void registrarAvaliacaoComNota() {
        System.out.println("\n=== REGISTRAR AVALIAÇÃO COM NOTA ===");
        System.out.print("Login do aluno: ");
        String loginAluno = scanner.nextLine();
        System.out.print("Descrição da avaliação: ");
        String descricao = scanner.nextLine();
        System.out.print("Nota: ");
        double nota = scanner.nextDouble();
        scanner.nextLine();

        avaliacaoService.registrarAvaliacao(loginAluno, descricao, nota);
    }

    // Outros métodos utilitários comuns...

    public abstract void exibirMenu();
}