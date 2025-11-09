import java.util.ArrayList;

public class Aluno {
    private String nome;
    private String matricula;
    private Curso curso;
    private ArrayList<Avaliacao> avaliacoes;

    public Aluno(String nome, String matricula, Curso curso) {
        if(nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do aluno inválido");
        }

        if(matricula == null || matricula.isBlank()) {
            throw new IllegalArgumentException("Matricula do aluno inválida");
        }

        if(curso == null) {
            throw new IllegalArgumentException("Curso do aluno não pode ser nulo");
        }

        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.avaliacoes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public Curso getCurso() {
        return curso;
    }

    public void adicionarAvaliacao(Avaliacao avaliacao){
        if (avaliacao != null) {
            avaliacoes.add(avaliacao);
            System.out.println("Avaliação '" + avaliacao.getDescricao() + "' adicionada para o aluno " + nome);
        }
    }

    public void exibirAluno(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Matricula: " + this.matricula);
        System.out.println("Curso: " + this.curso.getNome());
        System.out.println("Avaliacoes: ");
        if(avaliacoes.isEmpty()) {
            System.out.println("Nenhuma avaliacao foi encontrada.");
        } else {
            for (Avaliacao avaliacao : avaliacoes) {
                System.out.print("  -" + avaliacao.getDescricao() + ": ");
                System.out.println(avaliacao.getNota() >=0 ? avaliacao.getNota() : "Sem nota");
            }
        }
    }




}
