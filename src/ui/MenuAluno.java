package ui;

import model.Aluno;

public class MenuAluno extends MenuBase {

    public MenuAluno(Aluno aluno) {
        super(aluno);
    }

    @Override
    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== MENU ALUNO ===");
            System.out.println("1. Ver Minhas Avaliações");
            System.out.println("2. Ver Meus Dados");
            System.out.println("3. Ver Turmas");
            System.out.println("4. Logout");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> avaliacaoService.exibirAvaliacoesAluno(usuarioLogado.getLogin());
                case 2 -> ((Aluno) usuarioLogado).exibirAluno();
                case 3 -> turmaService.listarTurmas();
                case 4 -> System.out.println("Logout realizado com sucesso!");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }
}