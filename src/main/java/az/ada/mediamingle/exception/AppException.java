package az.ada.mediamingle.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class AppException extends RuntimeException{
    HttpStatus status;

    public AppException() {
    }

    public AppException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
