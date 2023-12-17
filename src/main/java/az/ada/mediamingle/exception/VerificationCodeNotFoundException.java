package az.ada.mediamingle.exception;

import org.springframework.http.HttpStatus;

public class VerificationCodeNotFoundException extends AppException{
    public VerificationCodeNotFoundException() {
        super("The verification code was not found to be a valid token for the user, please obtain a new verification token",
                HttpStatus.NOT_FOUND);
    }
}
