package az.ada.mediamingle.exception;

import org.springframework.http.HttpStatus;

public class EmailAlreadyExistsException extends AppException{
    public EmailAlreadyExistsException(String email) {
      super(String.format("Email address %s is already in use",email),HttpStatus.CONFLICT);
    }
}
