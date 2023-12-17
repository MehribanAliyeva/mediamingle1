package az.ada.mediamingle.controller;

import az.ada.mediamingle.model.RegistrationRequest;
import az.ada.mediamingle.model.dto.UserDto;
import az.ada.mediamingle.service.RegistrationService;
import az.ada.mediamingle.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/mediamingle/users")
@CrossOrigin
public class UserController {
    private final RegistrationService registrationService;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody RegistrationRequest registrationRequest){
        UserDto userDto = registrationService.register(registrationRequest);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Integer id){
        return ResponseEntity.ok(userService.getById(id));
    }
}
