package alura.challenge.forohub.domain.respuesta;

import java.time.LocalDateTime;

public record DatosRespuestasTopico(
        String autor,
        LocalDateTime fecha,
        String mensaje
) {
    public DatosRespuestasTopico(Respuesta respuesta) {
        this(respuesta.getAutor().getNombre(),
                respuesta.getFecha(),
                respuesta.getMensaje());
    }
}