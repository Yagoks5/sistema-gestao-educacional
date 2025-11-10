package ui;

import service.*;
import model.*;
import repository.*;
import java.util.Scanner;

public class MenuUI {
    private Scanner scanner;
    private AutenticacaoService autenticacaoService;
    private TurmaService turmaService;
    private RelatorioService relatorioService;
    private UsuarioRepository usuarioRepository;
    private CursoRepository cursoRepository;
    private TurmaRepository turmaRepository;

    public MenuUI() {
        this.scanner = new Scanner(System.in);
        this.usuarioRepository = new UsuarioRepository();
        this.cursoRepository = new CursoRepository();
        this.turmaRepository = new TurmaRepository();
        this.autenticacaoService = new AutenticacaoService(usuarioRepository);
        this.turmaService = new TurmaService(turmaRepository);
        this.relatorioService = new RelatorioService(usuarioRepository, cursoRepository);
        inicializarDados();
    }

    private void inicializarDados() {
        System.out.println("=== INICIALIZANDO SISTEMA ACADÊMICO ===\n");

        // Fase 1: Criando cursos, professores e alunos
        Curso ads = new Curso("Análise e Desenvolvimento de Sistemas", "ADS2417", 2400);
        Curso si = new Curso("Sistemas de Informação", "SI2024", 2600);

        Professor profJoao = new Professor("João Silva", "joao", "abcd", "Programação", "PROF001");
        Professor profMaria = new Professor("Maria Santos", "maria", "123", "Banco de Dados", "PROF002");

        Aluno aluno1 = new Aluno("Yago de Santana Ronchi", "yago", "1234", "24127513-5", ads);
        Aluno aluno2 = new Aluno("Ana Pereira", "ana", "4321", "MAT002", ads);
        Aluno aluno3 = new Aluno("Pedro Costa", "pedro", "9999", "MAT003", si);
        Aluno aluno4 = new Aluno("Mariana Lima", "mariana", "5555", "MAT004", ads);

        // Cursos específicos
        Curso cursoPresencial = new CursoPresencial("Engenharia de Software", "ENG101", 3000, "Sala 12 - Bloco G");
        Curso cursoEAD = new CursoEAD("Ciência de Dados", "CD202", 2800, "Studeo");

        // Administrador
        Administrador admin = new Administrador("Clara Menezes", "admin", "admin123", "Coordenadora");

        // Adicionar aos repositórios
        cursoRepository.adicionarCurso(ads);
        cursoRepository.adicionarCurso(si);
        cursoRepository.adicionarCurso(cursoPresencial);
        cursoRepository.adicionarCurso(cursoEAD);

        usuarioRepository.adicionarUsuario(profJoao);
        usuarioRepository.adicionarUsuario(profMaria);
        usuarioRepository.adicionarUsuario(aluno1);
        usuarioRepository.adicionarUsuario(aluno2);
        usuarioRepository.adicionarUsuario(aluno3);
        usuarioRepository.adicionarUsuario(aluno4);
        usuarioRepository.adicionarUsuario(admin);

        // Fase 2: Gerenciando turmas
        turmaService.criarTurma("TADS2417A", profJoao, ads);
        turmaService.criarTurma("TSI2024A", profMaria, si);

        turmaService.matricularAluno("TADS2417A", aluno1);
        turmaService.matricularAluno("TADS2417A", aluno2);
        turmaService.matricularAluno("TADS2417A", aluno4);
        turmaService.matricularAluno("TSI2024A", aluno3);

        // Tentativa de matrícula duplicada (para demonstrar controle)
        turmaService.matricularAluno("TADS2417A", aluno1);

        // Fase 3: Controle de avaliações
        Avaliacao prova1 = new Avaliacao("Prova 1 - Programação");
        Avaliacao trabalho1 = new Avaliacao("Trabalho Prático");
        Avaliacao prova2 = new Avaliacao("Prova 1 - Banco de Dados");

        aluno1.adicionarAvaliacao(prova1);
        aluno1.adicionarAvaliacao(trabalho1);
        aluno2.adicionarAvaliacao(prova2);
        aluno3.adicionarAvaliacao(prova1);

        // Atribuir notas
        prova1.atribuirNota(8.5);
        trabalho1.atribuirNota(9.0);
        prova2.atribuirNota(7.5);

        System.out.println("Dados inicializados com sucesso!\n");

        // Demonstrar alguns dados iniciais
        System.out.println("=== DEMONSTRAÇÃO INICIAL ===");
        ads.exibirCurso();
        System.out.println();
        aluno1.exibirAluno();
        System.out.println();
        aluno2.exibirAluno();
        System.out.println("\n" + "=" .repeat(50) + "\n");
    }

    public void exibirMenuPrincipal() {
        int opcao;
        do {
            System.out.println("\n=== SISTEMA ACADÊMICO ===");
            System.out.println("1. Autenticação");
            System.out.println("2. Gerenciar Turmas");
            System.out.println("3. Relatórios");
            System.out.println("4. Exibir Perfis");
            System.out.println("5. Controle de Avaliações");
            System.out.println("6. Tipos de Cursos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> menuAutenticacao();
                case 2 -> menuTurmas();
                case 3 -> menuRelatorios();
                case 4 -> menuPerfis();
                case 5 -> menuAvaliacoes();
                case 6 -> menuCursos();
                case 0 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        scanner.close();
    }

    private void menuAutenticacao() {
        System.out.println("\n=== AUTENTICAÇÃO ===");
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Usuario usuario = autenticacaoService.autenticar(login, senha);
        if (usuario != null) {
            System.out.println("✅ Autenticação bem-sucedida! Bem-vindo, " + usuario.getNome());
            usuario.exibirPerfil();
        } else {
            System.out.println("❌ Falha na autenticação!");
        }
    }

    private void menuTurmas() {
        System.out.println("\n=== GERENCIAR TURMAS ===");
        turmaService.listarTurmas();
    }

    private void menuRelatorios() {
        int opcao;
        do {
            System.out.println("\n=== MENU DE RELATÓRIOS ===");
            System.out.println("1. Relatório de Alunos");
            System.out.println("2. Relatório de Professores");
            System.out.println("3. Relatório de Cursos");
            System.out.println("4. Todos os Relatórios");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> relatorioService.gerarRelatorioAlunos();
                case 2 -> relatorioService.gerarRelatorioProfessores();
                case 3 -> relatorioService.gerarRelatorioCursos();
                case 4 -> relatorioService.gerarTodosRelatorios();
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void menuPerfis() {
        System.out.println("\n=== EXIBIR PERFIS ===");
        usuarioRepository.listarTodos().forEach(usuario -> {
            System.out.println("-".repeat(30));
            usuario.exibirPerfil();
        });
    }

    private void menuAvaliacoes() {
        System.out.println("\n=== CONTROLE DE AVALIAÇÕES ===");

        // Listar alunos com suas avaliações
        usuarioRepository.listarAlunos().forEach(aluno -> {
            System.out.println("\n--- " + aluno.getNome() + " ---");
            aluno.exibirAluno();
        });

        // Opção para adicionar nova avaliação
        System.out.println("\nDeseja adicionar nova avaliação? (s/n)");
        String resposta = scanner.nextLine();

        if (resposta.equalsIgnoreCase("s")) {
            System.out.print("Nome do aluno: ");
            String nomeAluno = scanner.nextLine();

            // Buscar aluno (simplificado - na prática, usaria ID ou matrícula)
            Aluno alunoEncontrado = usuarioRepository.listarAlunos().stream()
                    .filter(a -> a.getNome().equalsIgnoreCase(nomeAluno))
                    .findFirst()
                    .orElse(null);

            if (alunoEncontrado != null) {
                System.out.print("Descrição da avaliação: ");
                String descricao = scanner.nextLine();
                Avaliacao novaAvaliacao = new Avaliacao(descricao);
                alunoEncontrado.adicionarAvaliacao(novaAvaliacao);
            } else {
                System.out.println("Aluno não encontrado!");
            }
        }
    }

    private void menuCursos() {
        System.out.println("\n=== TIPOS DE CURSOS ===");
        cursoRepository.listarTodos().forEach(curso -> {
            System.out.println("-".repeat(40));
            curso.exibirCurso();
        });
    }
}