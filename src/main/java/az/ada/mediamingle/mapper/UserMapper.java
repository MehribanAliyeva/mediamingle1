package az.ada.mediamingle.mapper;


import az.ada.mediamingle.model.dto.UserDto;
import az.ada.mediamingle.model.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    User userDtoToEntity(UserDto userDto);
    UserDto userEntityToDto(User user);
}
