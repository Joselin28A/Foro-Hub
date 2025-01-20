package alura.challenge.forohub.domain.usuario;

public record DatosListadoUsuario(
        Long id,
        String nombre,
        String email,
        String perfil
) {
    public DatosListadoUsuario(Usuario usuario) {
        this(usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getPerfil().toString());
    }
}
