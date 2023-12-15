package az.musicapp.musicappdemo.model.mapper;


import az.musicapp.musicappdemo.model.dto.UserDto;
import az.musicapp.musicappdemo.model.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    User userDtoToEntity(UserDto userDto);
    UserDto userEntityToDto(User user);
}
