package alura.challenge.forohub.infra.errores;

import alura.challenge.forohub.excepcion.ValidacionExcepcion;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TrartarErrores {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException e) {
        var errores = e.getFieldErrors().stream().map(DatosErrorValidation::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(ValidacionExcepcion.class)
    public ResponseEntity tratarErrorValidacion(ValidacionExcepcion e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    private record DatosErrorValidation(String field, String typeError){
        public DatosErrorValidation(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
