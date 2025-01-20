package alura.challenge.forohub.domain.curso;

public record DatosListadoCurso(
        Long id,
        String nombre,
        String categoria
) {
    public DatosListadoCurso(Curso curso){
        this(curso.getId(),
                curso.getNombre(),
                curso.getCategoria().toString());
    }
}
