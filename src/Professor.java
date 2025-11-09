public class Professor extends Usuario implements Autenticacao {
    private String especialidade;
    private String registro;

    public Professor(String nome, String login, String senha, String especialidade, String registro) {
        super(nome, login, senha);

        this.especialidade = especialidade;
        this.registro = registro;

    }

    @Override
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }

    @Override
    public void exibirPerfil() {
        System.out.println("Perfil do professor " + nome);
        System.out.println("Especialidade: " + especialidade);
    }

    public void exibirProfessor(){
        System.out.println("Nome do professor: " + this.nome);
        System.out.println("Especialidade do professor: " + this.especialidade);
        System.out.println("Registro do professor: " + this.registro);
    }


    public void gerarRelatorio() {
        System.out.println("=== Relatório do Professor ===");
        System.out.println("Nome: " + nome);
        System.out.println("Especialidade: " + especialidade);
        System.out.println("Registro: " + registro);
        System.out.println("==============================\n");
    }


}
