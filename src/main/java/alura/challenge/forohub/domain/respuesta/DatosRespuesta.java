package alura.challenge.forohub.domain.respuesta;

import java.time.LocalDateTime;

public record DatosRespuesta(
        Long id,
        String autor,
        String titulo,
        LocalDateTime fecha,
        String mensaje

) {
    public DatosRespuesta(Respuesta respuesta){
        this(respuesta.getId(),
                respuesta.getAutor().getNombre(),
                respuesta.getTopico().getTitulo(),
                respuesta.getFecha(),
                respuesta.getMensaje());
    }
}
