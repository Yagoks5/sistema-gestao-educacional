import java.util.ArrayList;

public class Turma {
    private String codigo;
    private Professor professor;
    private Curso curso;
    private ArrayList<Aluno> listaAlunos;

    public Turma(String codigo, Professor professor, Curso curso)  {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Código da turma invalido");
        }

        this.codigo = codigo;
        this.professor = professor;
        this.curso = curso;
        this.listaAlunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        if(aluno !=null && !listaAlunos.contains(aluno)) {
            listaAlunos.add(aluno);
            System.out.println("Aluno " + aluno.getNome() + " adicionado a turma " + codigo);
        }
        else {
            System.out.println("Aluno inválido ou já está na turma" + codigo);
        }

    }

    public void removerAluno(Aluno aluno) {
        if (aluno != null && listaAlunos.remove(aluno)) {
            System.out.println("Aluno " + aluno.getNome() + " removido com sucesso");
        }
        else {
            System.out.println("Aluno não encontrado na turma" + codigo);
        }
    }

    public void mostrarResumo() {
        System.out.println("\n=== RESUMO DA TURMA ===");
        System.out.println("Código da Turma: " + codigo);
        System.out.println("Curso: " + curso.getNome());
        System.out.println("Professor: " + professor.getNome());
        System.out.println("Alunos matriculados: (" + listaAlunos.size() + "):");

        if(listaAlunos.isEmpty()) {
            System.out.println("Nenhum Aluno encontrado");
        } else {
            for (Aluno aluno : listaAlunos) {
                System.out.println("  - " + aluno.getNome());
            }
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Curso getCurso() {
        return curso;
    }

    public ArrayList<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public int getQuantidadeAlunos() {
        return listaAlunos.size();
    }


}
