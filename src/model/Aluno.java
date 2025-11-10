package model;

import java.util.ArrayList;

public class Aluno extends Usuario implements Autenticacao {
    private String matricula;
    private Curso curso;
    private ArrayList<Avaliacao> avaliacoes;

    public Aluno(String nome,String login, String senha, String matricula, Curso curso) {
        super(nome, login, senha);
        if(matricula == null || matricula.isBlank()) {
            throw new IllegalArgumentException("Matricula inválida");
        }
        this.matricula = matricula;
        this.curso = curso;
        this.avaliacoes = new ArrayList<>();
    }

    @Override
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }

    @Override
    public void exibirPerfil() {
        System.out.println("Perfil do aluno " + nome);
        System.out.println("Curso " + curso.getNome());
    }

    public void adicionarAvaliacao(Avaliacao avaliacao){
        if (avaliacao != null) {
            avaliacoes.add(avaliacao);
            System.out.println("Avaliação '" + avaliacao.getDescricao() + "' adicionada para o aluno " + nome);
        }
    }

    public void exibirAluno(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Matricula: " + this.matricula);
        System.out.println("Curso: " + this.curso.getNome());
        System.out.println("Avaliacoes: ");
        if(avaliacoes.isEmpty()) {
            System.out.println("Nenhuma avaliacao foi encontrada.");
        } else {
            for (Avaliacao avaliacao : avaliacoes) {
                System.out.print("  -" + avaliacao.getDescricao() + ": ");
                System.out.println(avaliacao.getNota() >=0 ? avaliacao.getNota() : "Sem nota");
            }
        }
    }

    public Curso getCurso() {
        return curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void gerarRelatorio() {
        System.out.println("=== Relatório do Aluno ===");
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Curso: " + curso.getNome());
        System.out.println("Quantidade de avaliações: " + avaliacoes.size());
        System.out.println("==========================\n");


    }

}
