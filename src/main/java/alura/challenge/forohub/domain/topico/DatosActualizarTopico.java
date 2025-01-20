package alura.challenge.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull
        Long id,
        @NotBlank
        String mensaje
) {
    public DatosActualizarTopico(Topico topico){
        this(topico.getId(),
                topico.getMensaje());
    }
}