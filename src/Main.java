import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Fase 1: Criando cursos, professores e alunos
        System.out.println("=== FASE 1 - MODELAGEM INICIAL ===\n");

        Curso ads = new Curso("Análise e Desenvolvimento de Sistemas", "ADS2417", 2400);
        Curso si = new Curso("Sistemas de Informação", "SI2024", 2600);

        Professor profJoao = new Professor("João Silva", "joao", "abcd", "Programação", "PROF001");
        Professor profMaria = new Professor("Maria Santos", "maria", "123", "Banco de Dados", "PROF002");

        Aluno aluno1 = new Aluno("Carlos Oliveira", "carlos", "1234", "MAT001", ads);
        Aluno aluno2 = new Aluno("Ana Pereira", "ana", "4321", "MAT002", ads);
        Aluno aluno3 = new Aluno("Pedro Costa", "pedro", "9999", "MAT003", si);
        Aluno aluno4 = new Aluno("Mariana Lima", "mariana", "5555", "MAT004", ads);

        Curso cursoPresencial = new CursoPresencial("Engenharia de Software", "ENG101", 3000, "Sala 12 - Bloco G");
        Curso cursoEAD = new CursoEAD("Ciência de Dados", "CD202", 2800, "Studeo");

        // Exibindo informações básicas
        ads.exibirCurso();
        System.out.println();
        profJoao.exibirProfessor();
        System.out.println();
        aluno1.exibirAluno();

        // Fase 2: Gerenciando turmas
        System.out.println("\n\n=== FASE 2 - ESTRUTURA ACADÊMICA ===\n");

        Turma turmaAds1 = new Turma("TADS2417A", profJoao, ads);
        Turma turmaSi1 = new Turma("TSI2024A", profMaria, si);

        turmaAds1.adicionarAluno(aluno1);
        turmaAds1.adicionarAluno(aluno2);
        turmaAds1.adicionarAluno(aluno4);
        turmaSi1.adicionarAluno(aluno3);

        turmaAds1.adicionarAluno(aluno1); // duplicado

        turmaAds1.mostrarResumo();
        turmaSi1.mostrarResumo();

        System.out.println("\n--- Removendo aluno da turma ---");
        turmaAds1.removerAluno(aluno1);
        turmaAds1.mostrarResumo();

        System.out.println("\n=== DEMONSTRANDO RELACIONAMENTOS ===");
        System.out.println("Aluno " + aluno1.getNome() + " está no curso: " + aluno1.getCurso().getNome());
        System.out.println("Turma " + turmaAds1.getCodigo() + " tem " + turmaAds1.getQuantidadeAlunos() + " alunos");


        System.out.println("\n\n=== FASE 3 - CONTROLE DE AVALIAÇÕES ===\n");

        Avaliacao prova1 = new Avaliacao("Prova 1");
        Avaliacao trabalho1 = new Avaliacao("Trabalho 1");

        aluno1.adicionarAvaliacao(prova1);
        aluno1.adicionarAvaliacao(trabalho1);

        prova1.atribuirNota(8.5);
        trabalho1.atribuirNota(9.0);

        aluno1.exibirAluno();
        aluno2.exibirAluno(); // sem avaliação


        System.out.println("\n\n=== FASE 4 - Diferentes Tipos de Cursos ===\n");

        cursoPresencial.exibirCurso();
        System.out.println("===========================");
        cursoEAD.exibirCurso();


        System.out.println("\n\n=== FASE 5 - AUTENTICAÇÃO E PERFIS ===\n");

        Aluno alunoLogin = new Aluno("Carlos Oliveira", "carlos", "1234", "MAT001", ads);
        Professor profLogin = new Professor("João Silva", "joao", "abcd", "Programação", "PROF001");
        Administrador admin = new Administrador("Clara Menezes", "admin", "admin123", "Coordenadora");

        System.out.println("Tentando login de aluno: " + (alunoLogin.autenticar("carlos", "1234") ? "Sucesso" : "Falha"));
        System.out.println("Tentando login de professor: " + (profLogin.autenticar("joao", "xyz") ? "Sucesso" : "Falha"));
        System.out.println("Tentando login de administrador: " + (admin.autenticar("admin", "admin123") ? "Sucesso" : "Falha"));

        System.out.println("\n--- Exibindo Perfis ---");
        alunoLogin.exibirPerfil();
        profLogin.exibirPerfil();
        admin.exibirPerfil();

        System.out.println("\n\n=== FASE 6 - RELATÓRIOS E ESTATÍSTICAS ===\n");
        ArrayList<Object> entidades = new ArrayList<>();
        entidades.add(aluno1);
        entidades.add(profJoao);
        entidades.add(ads);

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("=== MENU DE RELATÓRIOS ===");
            System.out.println("1. Gerar relatórios individuais");
            System.out.println("2. Gerar todos os relatórios");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Escolha o tipo de relatório:");
                    System.out.println("1. Aluno");
                    System.out.println("2. Professor");
                    System.out.println("3. Curso");
                    int tipo = sc.nextInt();

                    switch (tipo) {
                        case 1 -> aluno1.gerarRelatorio();
                        case 2 -> profJoao.gerarRelatorio();
                        case 3 -> ads.gerarRelatorio();
                        default -> System.out.println("Opção inválida!");
                    }
                    break;

                case 2:
                    System.out.println("\n--- Relatórios gerais ---");
                    for (Object entidade : entidades) {
                        if (entidade instanceof Aluno a) a.gerarRelatorio();
                        else if (entidade instanceof Professor p) p.gerarRelatorio();
                        else if (entidade instanceof Curso c) c.gerarRelatorio();
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();


    }
}
