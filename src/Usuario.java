public abstract class Usuario {
    protected String nome;
    protected String login;
    protected String senha;

    public Usuario(String nome, String login, String senha) {
        if(nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido");
        }

        if(login == null || login.isBlank()) {
            throw new IllegalArgumentException("Login inválido");
        }

        if(senha == null || senha.isBlank()) {
            throw new IllegalArgumentException("Senha inválida");
        }

        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public abstract void exibirPerfil();
}
