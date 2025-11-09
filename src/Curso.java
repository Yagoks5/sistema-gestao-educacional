public class Curso {
    private String nome;
    private String codigo;
    private int cargaHoraria;

    public Curso(String nome, String codigo, int cargaHoraria) {

        if(nome == null || nome.isBlank() ){
            throw new IllegalArgumentException("Nome do curso inválido");
        }

        if(codigo == null || codigo.isBlank() ){
            throw new IllegalArgumentException("Código do curso inválido");
        }

        if(cargaHoraria <=0){
            throw new IllegalArgumentException("Carga horária inválida");
        }

        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void exibirCurso(){
        System.out.println("Curso: " + this.nome);
        System.out.println("Codigo: " + this.codigo);
        System.out.println("Carga horária: " + this.cargaHoraria + " horas");
    }

}


