package az.ada.mediamingle.mapper;


import az.ada.mediamingle.model.dto.UserDto;
import az.ada.mediamingle.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper  {
    public User userDtoToEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
        }

        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());

        return user;
    }

    public UserDto userEntityToDto(User user) {
        if (user == null) {
            return null;
        }

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
