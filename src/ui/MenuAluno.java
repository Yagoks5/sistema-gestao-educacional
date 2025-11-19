package ui;

import model.Aluno;

public class MenuAluno extends MenuBase {

    public MenuAluno(Aluno aluno, MenuUI menuUI) {
        super(aluno, menuUI);
    }

    @Override
    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("       👤 MENU ALUNO - " + usuarioLogado.getNome());
            System.out.println("=".repeat(50));
            System.out.println("1. 📋 Ver Minhas Avaliações");
            System.out.println("2. 👁️  Ver Meus Dados");
            System.out.println("3. 📚 Ver Meu Curso");
            System.out.println("4. 📊 Gerar Meu Relatório");
            System.out.println("5. 🚪 Logout");
            System.out.print("\nEscolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> verMinhasAvaliacoes();
                    case 2 -> verMeusDados();
                    case 3 -> verMeuCurso();
                    case 4 -> gerarMeuRelatorio();
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

    private void verMinhasAvaliacoes() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("          MINHAS AVALIAÇÕES");
        System.out.println("=".repeat(50));
        avaliacaoService.exibirAvaliacoesAluno(usuarioLogado.getLogin());
    }

    private void verMeusDados() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           MEUS DADOS");
        System.out.println("=".repeat(50));
        ((Aluno) usuarioLogado).exibirAluno();
    }

    private void verMeuCurso() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           MEU CURSO");
        System.out.println("=".repeat(50));
        Aluno aluno = (Aluno) usuarioLogado;
        aluno.getCurso().exibirCurso();
    }

    private void gerarMeuRelatorio() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           MEU RELATÓRIO");
        System.out.println("=".repeat(50));
        ((Aluno) usuarioLogado).gerarRelatorio();
    }
}