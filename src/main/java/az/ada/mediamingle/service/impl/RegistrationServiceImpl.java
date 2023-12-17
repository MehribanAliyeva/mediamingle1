package az.ada.mediamingle.service.impl;

import az.ada.mediamingle.exception.EmailAlreadyExistsException;
import az.ada.mediamingle.exception.UsernameAlreadyExistsException;
import az.ada.mediamingle.mapper.UserMapper;
import az.ada.mediamingle.model.RegistrationRequest;
import az.ada.mediamingle.model.dto.UserDto;
import az.ada.mediamingle.model.entity.User;
import az.ada.mediamingle.model.entity.VerificationCode;
import az.ada.mediamingle.repo.UserRepository;
import az.ada.mediamingle.repo.VerificationCodeRepository;
import az.ada.mediamingle.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final VerificationCodeRepository verificationCodeRepository;
    private final EmailService emailService;
    @Transactional
    public UserDto register(RegistrationRequest request){
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new EmailAlreadyExistsException(request.getEmail());
        }
        if(userRepository.findByUsername(request.getUsername()).isPresent()){
            throw new UsernameAlreadyExistsException(request.getUsername());
        }
        User createdUser = User.builder().
                username(request.getUsername()).
                email(request.getEmail()).
                password(request.getPassword()).
                build();
        userRepository.save(createdUser);
        VerificationCode verificationCode = new VerificationCode(createdUser);
        verificationCodeRepository.save(verificationCode);
        sendConfirmationEmail(createdUser.getEmail(), verificationCode.getCode());
        UserDto userDto = userMapper.userEntityToDto(createdUser);
        return userDto;
    }
    private void sendConfirmationEmail(String email, String code){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject("Complete Registration");
        mailMessage.setFrom("anyemail@gmail.com");
        mailMessage.setText("To confirm your account, please click here:" + "http://localhost:8081/mediamingle/confirm-email?code="  + code);
        emailService.sendEmail(mailMessage);
    }
}
