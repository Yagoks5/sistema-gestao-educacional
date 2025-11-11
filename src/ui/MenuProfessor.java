package ui;

import model.Professor;

public class MenuProfessor extends MenuBase {

    public MenuProfessor(Professor professor) {
        super(professor);
    }

    @Override
    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== MENU PROFESSOR ===");
            System.out.println("1. Ver Turmas");
            System.out.println("2. Registrar Avaliações");
            System.out.println("3. Ver Meus Dados");
            System.out.println("4. Logout");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> turmaService.listarTurmas();
                case 2 -> menuAvaliacoesProfessor();
                case 3 -> ((Professor) usuarioLogado).exibirProfessor();
                case 4 -> System.out.println("Logout realizado com sucesso!");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }

    private void menuAvaliacoesProfessor() {
        int opcao;
        do {
            System.out.println("\n=== AVALIAÇÕES (PROFESSOR) ===");
            System.out.println("1. Registrar Avaliação com Nota");
            System.out.println("2. Registrar Avaliação sem Nota");
            System.out.println("3. Atribuir Nota a Avaliação");
            System.out.println("4. Ver Avaliações do Aluno");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> registrarAvaliacaoComNota();
                case 2 -> registrarAvaliacaoSemNota();
                case 3 -> atribuirNotaAvaliacao();
                case 4 -> verAvaliacoesAluno();
                case 5 -> System.out.println("Voltando ao menu anterior...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }

    private void registrarAvaliacaoSemNota() {

    }

    private void atribuirNotaAvaliacao() {

    }

    private void verAvaliacoesAluno() {

    }
}