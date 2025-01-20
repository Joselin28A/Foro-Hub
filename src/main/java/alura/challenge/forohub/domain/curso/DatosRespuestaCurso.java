package alura.challenge.forohub.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record DatosRespuestaCurso(
        Long id,
        @NotBlank
        String nombre,
        @NotBlank
        String categoria,
        @NotBlank
        String descripcion
) {
}