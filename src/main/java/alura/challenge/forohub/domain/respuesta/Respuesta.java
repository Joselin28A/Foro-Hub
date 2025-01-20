package alura.challenge.forohub.domain.respuesta;

import alura.challenge.forohub.domain.curso.Curso;
import alura.challenge.forohub.domain.topico.Topico;
import alura.challenge.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;
    private LocalDateTime fecha;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario autor;
    @Setter
    private Boolean solucion;

    // methods
    public Respuesta(@Valid DatosRegistroRespuesta datosRegistroRespuesta, Usuario autor, Topico topico){
        this.mensaje = datosRegistroRespuesta.mensaje();
        this.fecha = LocalDateTime.now();
        this.autor = autor;
        this.topico = topico;
        this.solucion = false;
    }

    public void solucionar() {
        this.solucion = true;
    }


}