package repository;

import model.Curso;
import java.util.ArrayList;
import java.util.List;

public class CursoRepository {
    private List<Curso> cursos;

    public CursoRepository() {
        this.cursos = new ArrayList<>();
    }

    public void adicionarCurso(Curso curso) {
        if (curso != null && !cursos.contains(curso)) {
            cursos.add(curso);
        }
    }

    public Curso buscarPorCodigo(String codigo) {
        return cursos.stream()
                .filter(c -> c.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }

    public List<Curso> listarTodos() {
        return new ArrayList<>(cursos);
    }
}