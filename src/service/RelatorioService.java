package service;

import model.Aluno;
import model.Professor;
import model.Curso;
import repository.UsuarioRepository;
import repository.CursoRepository;
import java.util.List;

public class RelatorioService {
    private UsuarioRepository usuarioRepository;
    private CursoRepository cursoRepository;

    public RelatorioService(UsuarioRepository usuarioRepository, CursoRepository cursoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }

    public void gerarRelatorioAlunos() {
        List<Aluno> alunos = usuarioRepository.listarAlunos();
        System.out.println("\n=== RELATÓRIO GERAL DE ALUNOS ===");
        alunos.forEach(Aluno::gerarRelatorio);
    }

    public void gerarRelatorioProfessores() {
        List<Professor> professores = usuarioRepository.listarProfessores();
        System.out.println("\n=== RELATÓRIO GERAL DE PROFESSORES ===");
        professores.forEach(Professor::gerarRelatorio);
    }

    public void gerarRelatorioCursos() {
        List<Curso> cursos = cursoRepository.listarTodos();
        System.out.println("\n=== RELATÓRIO GERAL DE CURSOS ===");
        cursos.forEach(Curso::gerarRelatorio);
    }

    public void gerarTodosRelatorios() {
        gerarRelatorioAlunos();
        gerarRelatorioProfessores();
        gerarRelatorioCursos();
    }
}