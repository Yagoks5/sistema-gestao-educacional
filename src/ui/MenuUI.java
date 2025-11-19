package ui;

import model.*;
import repository.*;
import service.*;
import java.util.Scanner;

public class MenuUI {
    private Scanner scanner;
    private AutenticacaoService autenticacaoService;
    private UsuarioRepository usuarioRepository;
    private CursoRepository cursoRepository;
    private TurmaRepository turmaRepository;
    private UsuarioService usuarioService;
    private CursoService cursoService;
    private TurmaService turmaService;
    private AvaliacaoService avaliacaoService;
    private RelatorioService relatorioService;

    public MenuUI() {
        this.scanner = new Scanner(System.in);
        this.usuarioRepository = new UsuarioRepository();
        this.cursoRepository = new CursoRepository();
        this.turmaRepository = new TurmaRepository();

        // Inicializar services
        this.usuarioService = new UsuarioService(usuarioRepository);
        this.cursoService = new CursoService(cursoRepository);
        this.turmaService = new TurmaService(turmaRepository);
        this.avaliacaoService = new AvaliacaoService(usuarioRepository);
        this.relatorioService = new RelatorioService(usuarioRepository, cursoRepository);
        this.autenticacaoService = new AutenticacaoService(usuarioRepository);

        inicializarDados();
    }

    private void inicializarDados() {
        // Criar cursos de exemplo
        cursoService.cadastrarCursoPresencial("Tecnologia da Informação", "TI001", 2000, "Sala 101");
        cursoService.cadastrarCursoEAD("Administração", "ADM001", 1800, "Plataforma EduConnect");
        cursoService.cadastrarCursoPresencial("Engenharia", "ENG001", 2400, "Sala 201");
        cursoService.cadastrarCursoEAD("Análise e desenvolvimento de sistema", "ADS001", 2400, "Plataforma EduConnect");

        // Criar usuários de exemplo
        usuarioService.cadastrarAdministrador("Admin Principal", "admin", "123", "Diretor");
        usuarioService.cadastrarProfessor("Dr. Silva", "prof.silva", "123", "Ciência da Computação", "REG001");
        usuarioService.cadastrarProfessor("Dra. Costa", "prof.costa", "123", "Administração", "REG002");

        // Criar alunos
        Curso cursoTI = cursoRepository.buscarPorCodigo("TI001");
        Curso cursoADM = cursoRepository.buscarPorCodigo("ADM001");
        Curso cursoADS = cursoRepository.buscarPorCodigo("ADS001");

        usuarioService.cadastrarAluno("João Almeida", "joao", "123", "2024001", cursoTI);
        usuarioService.cadastrarAluno("Maria Santos", "maria", "123", "2024002", cursoTI);
        usuarioService.cadastrarAluno("Pedro Oliveira", "pedro", "123", "2024003", cursoADM);
        usuarioService.cadastrarAluno("Yago Ronchi",  "yago", "1234", "2024004", cursoADS);
    }

    public void exibirMenuPrincipal() {
        int opcao;
        do {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("          🎓 SISTEMA EDUCONNECT");
            System.out.println("=".repeat(50));
            System.out.println("1. 👤 Login");
            System.out.println("2. 📊 Visualizar Dados do Sistema");
            System.out.println("3. 🚪 Sair");
            System.out.print("\nEscolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> fazerLogin();
                    case 2 -> visualizarDadosSistema();
                    case 3 -> {
                        System.out.println("\n👋 Obrigado por usar o EduConnect!");
                        System.out.println("Até logo!");
                    }
                    default -> System.out.println("❌ Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("❌ Erro na entrada! Digite um número válido.");
                scanner.nextLine();
                opcao = 0;
            }
        } while (opcao != 3);
    }

    private void fazerLogin() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("              LOGIN");
        System.out.println("=".repeat(50));
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Usuario usuarioLogado = autenticacaoService.autenticar(login, senha);

        if (usuarioLogado != null) {
            System.out.println("\n✅ Login realizado com sucesso!");
            System.out.println("🎉 Bem-vindo, " + usuarioLogado.getNome() + "!");
            exibirMenuPorTipoUsuario(usuarioLogado);
        } else {
            System.out.println("\n❌ Login ou senha inválidos!");
        }
    }

    private void exibirMenuPorTipoUsuario(Usuario usuario) {
        MenuBase menu;

        if (usuario instanceof Administrador) {
            menu = new MenuAdministrador((Administrador) usuario, this);
        } else if (usuario instanceof Professor) {
            menu = new MenuProfessor((Professor) usuario, this);
        } else if (usuario instanceof Aluno) {
            menu = new MenuAluno((Aluno) usuario, this);
        } else {
            System.out.println("❌ Tipo de usuário não suportado!");
            return;
        }

        menu.exibirMenu();
    }

    private void visualizarDadosSistema() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("        📊 DADOS DO SISTEMA (VISUALIZAÇÃO PÚBLICA)");
        System.out.println("=".repeat(50));

        System.out.println("\n📚 Cursos Cadastrados:");
        cursoService.listarTodosCursos();

        System.out.println("\n👥 Usuários Cadastrados:");
        usuarioService.listarTodosUsuarios();

        System.out.println("\n📋 Turmas Cadastradas:");
        turmaService.listarTurmas();
    }

    // Getters para acesso aos services pelos menus
    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public CursoService getCursoService() {
        return cursoService;
    }

    public TurmaService getTurmaService() {
        return turmaService;
    }

    public AvaliacaoService getAvaliacaoService() {
        return avaliacaoService;
    }

    public RelatorioService getRelatorioService() {
        return relatorioService;
    }

    public CursoRepository getCursoRepository() {
        return cursoRepository;
    }

    public TurmaRepository getTurmaRepository() {
        return turmaRepository;
    }

    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }

    public Scanner getScanner() {
        return scanner;
    }
}