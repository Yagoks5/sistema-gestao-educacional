package repository;

import model.Turma;
import java.util.ArrayList;
import java.util.List;

public class TurmaRepository {
    private List<Turma> turmas;

    public TurmaRepository() {
        this.turmas = new ArrayList<>();
    }

    public void adicionarTurma(Turma turma) {
        if (turma != null && !turmas.contains(turma)) {
            turmas.add(turma);
        }
    }

    public Turma buscarPorCodigo(String codigo) {
        return turmas.stream()
                .filter(t -> t.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }

    public List<Turma> listarTodos() {
        return new ArrayList<>(turmas);
    }
}