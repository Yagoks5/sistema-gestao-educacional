package service;

import model.Usuario;
import model.Autenticacao;
import repository.UsuarioRepository;

public class AutenticacaoService {
    private UsuarioRepository usuarioRepository;

    public AutenticacaoService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario autenticar(String login, String senha) {
        Usuario usuario = usuarioRepository.buscarPorLogin(login);
        if (usuario instanceof Autenticacao autenticavel) {
            if (autenticavel.autenticar(login, senha)) {
                return usuario;
            }
        }
        return null;
    }
}