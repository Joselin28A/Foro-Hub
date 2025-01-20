package alura.challenge.forohub.domain.respuesta;

import java.time.LocalDateTime;

public record DatosListadoRespuesta(
        Long id,
        String titulo,
        String autor,
        LocalDateTime fecha
) {
    public DatosListadoRespuesta(Respuesta respuesta){
        this(respuesta.getId(),
                respuesta.getTopico().getTitulo(),
                respuesta.getAutor().getNombre(),
                respuesta.getFecha());
    }
}
