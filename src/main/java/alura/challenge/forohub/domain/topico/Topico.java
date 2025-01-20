package alura.challenge.forohub.domain.topico;

import alura.challenge.forohub.domain.curso.Curso;
import alura.challenge.forohub.domain.respuesta.Respuesta;
import alura.challenge.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Setter
    private LocalDateTime fecha;
    @Setter
    @Enumerated(EnumType.STRING)
    private Estado status;
    private Boolean activo;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Respuesta> respuestas = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario autor;

    // methods
    public Topico(DatosRegistroTopico datosRegistroTopico, Usuario autor, Curso curso){
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fecha = LocalDateTime.now();
        this.status = Estado.ABIERTO;
        this.activo = true;
        this.autor = autor;
        this.curso = curso;
    }

    public void desactivarTopico(){
        this.activo = false;
    }

    public void actualizarTopico(DatosActualizarTopico dActualizarTopico) {
        if (dActualizarTopico.mensaje() != null){
            this.mensaje = dActualizarTopico.mensaje();
        }
        this.fecha = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }


}