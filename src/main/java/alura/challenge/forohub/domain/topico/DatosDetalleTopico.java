package alura.challenge.forohub.domain.topico;

import alura.challenge.forohub.domain.curso.DatosRespuestaCurso;
import alura.challenge.forohub.domain.respuesta.DatosRegistroRespuesta;
import alura.challenge.forohub.domain.usuario.DatosRespuestaUsuario;

import java.time.LocalDateTime;
import java.util.List;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        DatosRespuestaCurso curso,
        Estado status,
        LocalDateTime fecha,
        DatosRespuestaUsuario autor,
        String mensaje,
        List<DatosRegistroRespuesta> respuestas

) {
}