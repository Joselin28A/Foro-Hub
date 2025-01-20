package alura.challenge.forohub.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String curso,
        String autor,
        LocalDateTime fecha,
        Estado status,
        Integer numRespuestas
) {
    public DatosListadoTopico(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getCurso().getNombre(),
                topico.getAutor().getNombre(),
                topico.getFecha(),
                topico.getStatus(),
                topico.getRespuestas().size());
    }
}