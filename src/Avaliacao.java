public class Avaliacao {
    private double nota;
    private String descricao;

    public  Avaliacao(String descricao) {
        if(descricao == null || descricao.isBlank()){
            throw new IllegalArgumentException("O campo descricao deve ser preenchido.");
        }

        this.descricao = descricao;
        this.nota = -1; // forma que encontrei de mostrar que nao foi atribuida
    }

    public void atribuirNota(double valor ) {
        if(valor < 0 || valor >10) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 10");
        }
        this.nota = valor;
    }

    public double getNota() {
        return nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void exibirAvaliacao(){
        System.out.println("Avaliação: " + descricao);
        if(nota >=0) {
            System.out.println("Nota: " + nota);
        } else {
            System.out.println("Nota ainda não atribuida");
        }
    }

}
