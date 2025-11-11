package service;

import model.*;
import repository.UsuarioRepository;
import java.util.List;

public class AvaliacaoService {
    private UsuarioRepository usuarioRepository;

    public AvaliacaoService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void registrarAvaliacao(String loginAluno, String descricao, double nota) {
        try {
            Usuario usuario = usuarioRepository.buscarPorLogin(loginAluno);
            if (usuario instanceof Aluno aluno) {
                Avaliacao avaliacao = new Avaliacao(descricao);
                avaliacao.atribuirNota(nota);
                aluno.adicionarAvaliacao(avaliacao);
                System.out.println("✅ Avaliação registrada para " + aluno.getNome());
            } else {
                System.out.println("❌ Usuário não é um aluno ou não encontrado!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Erro ao registrar avaliação: " + e.getMessage());
        }
    }

    public void registrarAvaliacaoSemNota(String loginAluno, String descricao) {
        try {
            Usuario usuario = usuarioRepository.buscarPorLogin(loginAluno);
            if (usuario instanceof Aluno aluno) {
                Avaliacao avaliacao = new Avaliacao(descricao);
                aluno.adicionarAvaliacao(avaliacao);
                System.out.println("✅ Avaliação (sem nota) registrada para " + aluno.getNome());
            } else {
                System.out.println("❌ Usuário não é um aluno ou não encontrado!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Erro ao registrar avaliação: " + e.getMessage());
        }
    }

    public void atribuirNota(String loginAluno, String descricaoAvaliacao, double nota) {
        Usuario usuario = usuarioRepository.buscarPorLogin(loginAluno);
        if (usuario instanceof Aluno aluno) {
            // Em uma implementação real, buscaríamos a avaliação específica
            // Aqui vamos simular encontrando pela descrição
            System.out.println("📝 Atribuindo nota " + nota + " para " + descricaoAvaliacao + " do aluno " + aluno.getNome());
            // Implementação simplificada - na prática precisaria de um repositório de avaliações
        } else {
            System.out.println("❌ Aluno não encontrado!");
        }
    }

    public void exibirAvaliacoesAluno(String loginAluno) {
        Usuario usuario = usuarioRepository.buscarPorLogin(loginAluno);
        if (usuario instanceof Aluno aluno) {
            System.out.println("\n=== AVALIAÇÕES DE " + aluno.getNome().toUpperCase() + " ===");
            aluno.exibirAluno();
        } else {
            System.out.println("❌ Aluno não encontrado!");
        }
    }
}