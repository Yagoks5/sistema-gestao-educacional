public class CursoPresencial extends Curso {
    private String salaDeAula;

    public CursoPresencial(String nome, String codigo, int cargaHoraria, String salaDeAula) {
        super(nome, codigo, cargaHoraria);
        this.salaDeAula = salaDeAula;
    }

    @Override
    public void exibirCurso() {
        super.exibirCurso();
        System.out.println("Sala de aula: " + this.salaDeAula);
    }

    public String getSalaDeAula() {
        return salaDeAula;
    }
}
