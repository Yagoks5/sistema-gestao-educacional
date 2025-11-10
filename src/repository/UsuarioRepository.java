package repository;

import model.Usuario;
import model.Aluno;
import model.Professor;
import model.Administrador;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {
    private List<Usuario> usuarios;

    public UsuarioRepository() {
        this.usuarios = new ArrayList<>();
    }

    public void adicionarUsuario(Usuario usuario) {
        if (usuario != null && !usuarios.contains(usuario)) {
            usuarios.add(usuario);
        }
    }

    public Usuario buscarPorLogin(String login) {
        return usuarios.stream()
                .filter(u -> u.getLogin().equals(login))
                .findFirst()
                .orElse(null);
    }

    public List<Aluno> listarAlunos() {
        return usuarios.stream()
                .filter(u -> u instanceof Aluno)
                .map(u -> (Aluno) u)
                .toList();
    }

    public List<Professor> listarProfessores() {
        return usuarios.stream()
                .filter(u -> u instanceof Professor)
                .map(u -> (Professor) u)
                .toList();
    }

    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios);
    }
}