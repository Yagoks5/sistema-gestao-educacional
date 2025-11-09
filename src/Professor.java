public class Professor {
    private String nome;
    private String especialidade;
    private String registro;

    public Professor(String nome, String especialidade, String registro) {

       if(nome == null || nome.isBlank()) {
           throw new IllegalArgumentException("Nome do professor inválido");
       }

       if (registro == null || registro.isBlank()) {
           throw new IllegalArgumentException("Registro do professor inválido");
       }

        this.nome = nome;
        this.especialidade = especialidade;
        this.registro = registro;
    }

    public String getNome() {
        return nome;
    }


    public String getEspecialidade() {
        return especialidade;
    }

    public String getRegistro() {
        return registro;
    }

    public void exibirProfessor(){
        System.out.println("Nome do professor: " + this.nome);
        System.out.println("Especialidade do professor: " + this.especialidade);
        System.out.println("Registro do professor: " + this.registro);
    }


}
