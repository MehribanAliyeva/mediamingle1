package az.ada.mediamingle.controller;

import az.ada.mediamingle.model.dto.UserDto;
import az.ada.mediamingle.service.impl.VerificationCodeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mediamingle/confirm-email")
@AllArgsConstructor
@CrossOrigin
public class VerificationCodeController {
    private final VerificationCodeService verificationCodeService;

    @PostMapping
    public ResponseEntity<UserDto> verify(@RequestParam("code") String code){
        UserDto userDto = verificationCodeService.verify(code);
        return ResponseEntity.ok(userDto);
    }
}
