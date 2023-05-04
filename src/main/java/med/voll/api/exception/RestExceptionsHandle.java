package med.voll.api.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class RestExceptionsHandle {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleEntityNotFound(EntityNotFoundException ex) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DadosErrorValidacao>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        var allErrors = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(allErrors.stream().map(DadosErrorValidacao::new).toList());
    }

    private record DadosErrorValidacao(String campo, String msg) {
        public DadosErrorValidacao(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
