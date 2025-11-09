public class Aluno {
    private String nome;
    private String matricula;
    private Curso curso;

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

    public void exibirAluno(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Matricula: " + this.matricula);
        System.out.println("Curso: " + this.curso.getNome());
    }




}
