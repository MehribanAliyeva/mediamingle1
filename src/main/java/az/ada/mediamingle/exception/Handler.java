package az.ada.mediamingle.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Handler {
    @ExceptionHandler(AppException.class)
    protected ResponseEntity<ExceptionBody> handleException(AppException e){
      ExceptionBody exceptionBody = new ExceptionBody(e.getMessage(),e.getStatus());
      return ResponseEntity.status(e.getStatus()).body(exceptionBody);
    }
}
