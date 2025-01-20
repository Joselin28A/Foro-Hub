package alura.challenge.forohub.domain.topico;

import alura.challenge.forohub.domain.respuesta.DatosRespuestasTopico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String curso,
        String autor,
        LocalDateTime fecha,
        Estado status,
        String mensaje,
        List<DatosRespuestasTopico> respuestas
) {
    public DatosRespuestaTopico(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getCurso().getNombre(),
                topico.getAutor().getNombre(),
                topico.getFecha(),
                topico.getStatus(),
                topico.getMensaje(),
                topico.getRespuestas().stream().map(DatosRespuestasTopico::new).collect(Collectors.toList())
        );
    }
}