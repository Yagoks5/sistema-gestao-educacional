public class Administrador extends Usuario implements Autenticacao {
    public String cargo;

    public Administrador(String nome, String login, String senha, String cargo)  {
        super(nome, login, senha);
        this.cargo = cargo;
    }

    @Override
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }

    @Override
    public void exibirPerfil() {
        System.out.println("Perfil do Administrador " + nome);
        System.out.println("Cargo " + cargo);
    }

}
