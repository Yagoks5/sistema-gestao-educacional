package ui;

import model.Administrador;

public class MenuAdministrador extends MenuBase {

    public MenuAdministrador(Administrador administrador) {
        super(administrador);
    }

    @Override
    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== MENU ADMINISTRADOR ===");
            System.out.println("1. Gerenciar Usuários");
            System.out.println("2. Gerenciar Cursos");
            System.out.println("3. Gerenciar Turmas");
            System.out.println("4. Gerar Relatórios");
            System.out.println("5. Avaliações");
            System.out.println("6. Logout");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> menuGerenciarUsuarios();
                case 2 -> menuGerenciarCursos();
                case 3 -> menuGerenciarTurmas();
                case 4 -> menuRelatorios();
                case 5 -> menuAvaliacoes();
                case 6 -> System.out.println("Logout realizado com sucesso!");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 6);
    }

    private void menuGerenciarUsuarios() {
        int opcao;
        do {
            System.out.println("\n=== GERENCIAR USUÁRIOS ===");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Professor");
            System.out.println("3. Cadastrar Administrador");
            System.out.println("4. Listar Todos Usuários");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarAluno();
                case 2 -> cadastrarProfessor();
                case 3 -> cadastrarAdministrador();
                case 4 -> usuarioService.listarTodosUsuarios();
                case 5 -> System.out.println("Voltando ao menu anterior...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }

    private void cadastrarAdministrador() {
        System.out.println("\n=== CADASTRAR ADMINISTRADOR ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();

        usuarioService.cadastrarAdministrador(nome, login, senha, cargo);
    }

    private void menuGerenciarCursos() {
        // Implementação específica do admin para gerenciar cursos
    }

    private void menuGerenciarTurmas() {
        // Implementação específica do admin para gerenciar turmas
    }

    private void menuRelatorios() {
        // Implementação específica do admin para relatórios
    }

    private void menuAvaliacoes() {
        // Implementação específica do admin para avaliações
    }
}