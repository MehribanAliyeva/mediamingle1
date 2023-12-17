package az.ada.mediamingle.exception;

import org.springframework.http.HttpStatus;

public class VerificationCodeIsExpiredException extends AppException{

    public VerificationCodeIsExpiredException() {
        super("Verification code is expired, please obtain a new token",HttpStatus.UNAUTHORIZED);
    }
}
