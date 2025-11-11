package ui;

import model.*;
import repository.*;
import service.*;
import java.util.Scanner;

public class MenuUI {
    private Scanner scanner;
    private AutenticacaoService autenticacaoService;
    private UsuarioRepository usuarioRepository;

    public MenuUI() {
        this.scanner = new Scanner(System.in);
        this.usuarioRepository = new UsuarioRepository();
        this.autenticacaoService = new AutenticacaoService(usuarioRepository);
        inicializarDados();
    }

    private void inicializarDados() {
        // Inicialização de dados de teste (mantida igual)
        Curso cursoTI = new CursoPresencial("Tecnologia da Informação", "TI001", 2000, "Sala 101");
        Curso cursoADM = new CursoEAD("Administração", "ADM001", 1800, "Plataforma EduConnect");

        CursoRepository cursoRepo = new CursoRepository();
        cursoRepo.adicionarCurso(cursoTI);
        cursoRepo.adicionarCurso(cursoADM);

        UsuarioService usuarioService = new UsuarioService(usuarioRepository);
        usuarioService.cadastrarAdministrador("Admin Principal", "admin", "123", "Diretor");
        usuarioService.cadastrarProfessor("Dr. Silva", "prof.silva", "123", "Ciência da Computação", "REG001");
        usuarioService.cadastrarAluno("João Almeida", "joao", "123", "2024001", cursoTI);
    }

    public void exibirMenuPrincipal() {
        int opcao;
        do {
            System.out.println("\n=== SISTEMA EDUCONNECT ===");
            System.out.println("1. Login");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> fazerLogin();
                case 2 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 2);
    }

    private void fazerLogin() {
        System.out.println("\n=== LOGIN ===");
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Usuario usuarioLogado = autenticacaoService.autenticar(login, senha);

        if (usuarioLogado != null) {
            System.out.println("✅ Login realizado com sucesso! Bem-vindo, " + usuarioLogado.getNome());
            exibirMenuPorTipoUsuario(usuarioLogado);
        } else {
            System.out.println("❌ Login ou senha inválidos!");
        }
    }

    private void exibirMenuPorTipoUsuario(Usuario usuario) {
        MenuBase menu;

        if (usuario instanceof Administrador) {
            menu = new MenuAdministrador((Administrador) usuario);
        } else if (usuario instanceof Professor) {
            menu = new MenuProfessor((Professor) usuario);
        } else if (usuario instanceof Aluno) {
            menu = new MenuAluno((Aluno) usuario);
        } else {
            System.out.println("❌ Tipo de usuário não suportado!");
            return;
        }

        menu.exibirMenu();
    }
}