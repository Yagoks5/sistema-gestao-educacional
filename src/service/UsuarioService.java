package service;

import model.*;
import repository.UsuarioRepository;
import java.util.List;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void cadastrarAluno(String nome, String login, String senha, String matricula, Curso curso) {
        try {
            Aluno aluno = new Aluno(nome, login, senha, matricula, curso);
            usuarioRepository.adicionarUsuario(aluno);
            System.out.println("✅ Aluno " + nome + " cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Erro ao cadastrar aluno: " + e.getMessage());
        }
    }

    public void cadastrarProfessor(String nome, String login, String senha, String especialidade, String registro) {
        try {
            Professor professor = new Professor(nome, login, senha, especialidade, registro);
            usuarioRepository.adicionarUsuario(professor);
            System.out.println("✅ Professor " + nome + " cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Erro ao cadastrar professor: " + e.getMessage());
        }
    }

    public void cadastrarAdministrador(String nome, String login, String senha, String cargo) {
        try {
            Administrador admin = new Administrador(nome, login, senha, cargo);
            usuarioRepository.adicionarUsuario(admin);
            System.out.println("✅ Administrador " + nome + " cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Erro ao cadastrar administrador: " + e.getMessage());
        }
    }

    public List<Aluno> listarAlunos() {
        return usuarioRepository.listarAlunos();
    }

    public List<Professor> listarProfessores() {
        return usuarioRepository.listarProfessores();
    }

    public Usuario buscarPorLogin(String login) {
        return usuarioRepository.buscarPorLogin(login);
    }

    public void listarTodosUsuarios() {
        System.out.println("\n=== LISTA DE USUÁRIOS ===");
        usuarioRepository.listarTodos().forEach(usuario -> {
            System.out.println("-".repeat(30));
            usuario.exibirPerfil();
        });
    }
}