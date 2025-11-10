package service;

import model.Turma;
import model.Aluno;
import model.Professor;
import model.Curso;
import repository.TurmaRepository;

public class TurmaService {
    private TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public void criarTurma(String codigo, Professor professor, Curso curso) {
        Turma turma = new Turma(codigo, professor, curso);
        turmaRepository.adicionarTurma(turma);
    }

    public void matricularAluno(String codigoTurma, Aluno aluno) {
        Turma turma = turmaRepository.buscarPorCodigo(codigoTurma);
        if (turma != null) {
            turma.adicionarAluno(aluno);
        }
    }

    public void listarTurmas() {
        turmaRepository.listarTodos().forEach(Turma::mostrarResumo);
    }
}