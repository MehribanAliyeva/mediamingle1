package az.ada.mediamingle.service.impl;

import az.ada.mediamingle.mapper.UserMapper;
import az.ada.mediamingle.model.dto.UserDto;
import az.ada.mediamingle.model.entity.User;
import az.ada.mediamingle.repo.UserRepository;
import az.ada.mediamingle.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public UserDto getById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        UserDto userDto;
        if(user.isPresent()) {
            userDto = UserDto.builder().email(user.get().getEmail())
                    .id(id)
                    .username(user.get().getUsername())
                    .build();
        }else{
            userDto = UserDto.builder().build();
        }
        System.out.println(userDto);
        log.info(String.valueOf(userDto));
        return  userDto;
    }
}
