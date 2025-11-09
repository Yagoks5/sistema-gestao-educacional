public class Main {
    public static void main(String[] args) {
        // Fase 1: Criando cursos, professores e alunos
        System.out.println("=== FASE 1 - MODELAGEM INICIAL ===\n");

        Curso ads = new Curso("Análise e Desenvolvimento de Sistemas", "ADS2417", 2400);
        Curso si = new Curso("Sistemas de Informação", "SI2024", 2600);

        Professor profJoao = new Professor("João Silva", "Programação", "PROF001");
        Professor profMaria = new Professor("Maria Santos", "Banco de Dados", "PROF002");

        Aluno aluno1 = new Aluno("Carlos Oliveira", "MAT001", ads);
        Aluno aluno2 = new Aluno("Ana Pereira", "MAT002", ads);
        Aluno aluno3 = new Aluno("Pedro Costa", "MAT003", si);
        Aluno aluno4 = new Aluno("Mariana Lima", "MAT004", ads);

        // Exibindo informações básicas
        ads.exibirCurso();
        System.out.println();
        profJoao.exibirProfessor();
        System.out.println();
        aluno1.exibirAluno();

        // Fase 2: Gerenciando turmas
        System.out.println("\n\n=== FASE 2 - ESTRUTURA ACADÊMICA ===\n");

        // Criando turmas
        Turma turmaAds1 = new Turma("TADS2417A", profJoao, ads);
        Turma turmaSi1 = new Turma("TSI2024A", profMaria, si);

        // Adicionando alunos às turmas
        turmaAds1.adicionarAluno(aluno1);
        turmaAds1.adicionarAluno(aluno2);
        turmaAds1.adicionarAluno(aluno4);

        turmaSi1.adicionarAluno(aluno3);

        // Tentando adicionar aluno duplicado
        turmaAds1.adicionarAluno(aluno1);

        // Mostrando resumo das turmas
        turmaAds1.mostrarResumo();
        turmaSi1.mostrarResumo();

        // Testando remoção de aluno
        System.out.println("\n--- Removendo aluno da turma ---");
        turmaAds1.removerAluno(aluno1);
        turmaAds1.mostrarResumo();

        // Demonstrando relacionamentos
        System.out.println("\n=== DEMONSTRANDO RELACIONAMENTOS ===");
        System.out.println("Aluno " + aluno1.getNome() + " está no curso: " + aluno1.getCurso().getNome());
        System.out.println("Turma " + turmaAds1.getCodigo() + " tem " + turmaAds1.getQuantidadeAlunos() + " alunos");


        System.out.println("\n\n=== FASE 3 - CONTROLE DE AVALIAÇÕES ===\n");

        Avaliacao prova1 = new Avaliacao("Prova 1");
        Avaliacao trabalho1 = new Avaliacao("Trabalho 1");

        aluno1.adicionarAvaliacao(prova1);
        aluno1.adicionarAvaliacao(trabalho1);

        // Tentando atribuir notas
        prova1.atribuirNota(8.5);
        trabalho1.atribuirNota(9.0);

        aluno1.exibirAluno();
        aluno2.exibirAluno(); // mostrar que nao tem avaliacao encontrada.



    }


}