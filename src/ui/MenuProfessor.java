package ui;

import model.Professor;

public class MenuProfessor extends MenuBase {

    public MenuProfessor(Professor professor, MenuUI menuUI) {
        super(professor, menuUI);
    }

    @Override
    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("      👨‍🏫 MENU PROFESSOR - " + usuarioLogado.getNome());
            System.out.println("=".repeat(50));
            System.out.println("1. 📋 Ver Minhas Turmas");
            System.out.println("2. ✏️  Registrar Avaliações");
            System.out.println("3. 📊 Gerar Meu Relatório");
            System.out.println("4. 👁️  Ver Meus Dados");
            System.out.println("5. 🚪 Logout");
            System.out.print("\nEscolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> verMinhasTurmas();
                    case 2 -> menuAvaliacoesProfessor();
                    case 3 -> gerarMeuRelatorio();
                    case 4 -> ((Professor) usuarioLogado).exibirProfessor();
                    case 5 -> System.out.println("\n✅ Logout realizado com sucesso!");
                    default -> System.out.println("❌ Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("❌ Entrada inválida!");
                scanner.nextLine();
                opcao = 0;
            }
        } while (opcao != 5);
    }

    private void verMinhasTurmas() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           MINHAS TURMAS");
        System.out.println("=".repeat(50));
        turmaService.listarTurmas();
    }

    private void menuAvaliacoesProfessor() {
        int opcao;
        do {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("        GERENCIAR AVALIAÇÕES (PROFESSOR)");
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

    private void gerarMeuRelatorio() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           MEU RELATÓRIO");
        System.out.println("=".repeat(50));
        ((Professor) usuarioLogado).gerarRelatorio();
    }
}