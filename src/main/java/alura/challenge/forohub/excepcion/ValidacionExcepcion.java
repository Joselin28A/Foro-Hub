package alura.challenge.forohub.excepcion;

public class ValidacionExcepcion extends RuntimeException {
  public ValidacionExcepcion(String mensaje) {
    super(mensaje);
  }
}
