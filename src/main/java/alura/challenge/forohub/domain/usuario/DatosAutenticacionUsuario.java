package alura.challenge.forohub.domain.usuario;

public record DatosAutenticacionUsuario(
        String email,
        String clave
) {
    public DatosAutenticacionUsuario(Usuario usuario){
        this(usuario.getEmail(), usuario.getClave());
    }
}