package service;

import model.*;
import repository.CursoRepository;
import java.util.List;

public class CursoService {
    private CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public void cadastrarCursoPresencial(String nome, String codigo, int cargaHoraria, String sala) {
        try {
            Curso curso = new CursoPresencial(nome, codigo, cargaHoraria, sala);
            cursoRepository.adicionarCurso(curso);
            System.out.println("✅ Curso presencial " + nome + " cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Erro ao cadastrar curso: " + e.getMessage());
        }
    }

    public void cadastrarCursoEAD(String nome, String codigo, int cargaHoraria, String plataforma) {
        try {
            Curso curso = new CursoEAD(nome, codigo, cargaHoraria, plataforma);
            cursoRepository.adicionarCurso(curso);
            System.out.println("✅ Curso EAD " + nome + " cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Erro ao cadastrar curso: " + e.getMessage());
        }
    }

    public Curso buscarCursoPorCodigo(String codigo) {
        Curso curso = cursoRepository.buscarPorCodigo(codigo);
        if (curso == null) {
            System.out.println("❌ Curso com código " + codigo + " não encontrado!");
        }
        return curso;
    }

    public void listarTodosCursos() {
        List<Curso> cursos = cursoRepository.listarTodos();
        if (cursos.isEmpty()) {
            System.out.println("📭 Nenhum curso cadastrado!");
        } else {
            System.out.println("\n=== LISTA DE CURSOS ===");
            cursos.forEach(Curso::exibirCurso);
        }
    }
}