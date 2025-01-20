package alura.challenge.forohub.domain.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private String descripcion;

    // methods
    public Curso(DatosRegistroCurso datosRegistroCurso) {
        this.nombre= datosRegistroCurso.nombre();
        this.categoria= datosRegistroCurso.categoria();
        this.descripcion= datosRegistroCurso.descripcion();
    }


}