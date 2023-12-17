package az.ada.mediamingle.exception;

import org.springframework.http.HttpStatus;

public class UsernameAlreadyExistsException extends AppException{

    public UsernameAlreadyExistsException(String username) {
        super(String.format("Username %s is already in use",username),HttpStatus.CONFLICT);
    }
}
