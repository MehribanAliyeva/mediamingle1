package az.ada.mediamingle.service.impl;

import az.ada.mediamingle.exception.VerificationCodeIsExpiredException;
import az.ada.mediamingle.exception.VerificationCodeNotFoundException;
import az.ada.mediamingle.mapper.UserMapper;
import az.ada.mediamingle.model.dto.UserDto;
import az.ada.mediamingle.model.entity.User;
import az.ada.mediamingle.model.entity.VerificationCode;
import az.ada.mediamingle.repo.UserRepository;
import az.ada.mediamingle.repo.VerificationCodeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VerificationCodeService {
    private final VerificationCodeRepository verificationCodeRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto verify(String code){
        Optional<VerificationCode> verificationCode = verificationCodeRepository.findByCode(code);
        User user;
        if(verificationCode.isPresent()){
            if(verificationCode.get().getExpiresAt().isAfter(LocalDateTime.now())){
                user = verificationCode.get().getUser();
                userRepository.save(user);
            }else{
              throw new VerificationCodeIsExpiredException();
            }
        }else{
            throw new VerificationCodeNotFoundException();
        }
        return userMapper.userEntityToDto(user);
    }
}
