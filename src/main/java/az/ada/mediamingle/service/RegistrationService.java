package az.ada.mediamingle.service;

import az.ada.mediamingle.model.RegistrationRequest;
import az.ada.mediamingle.model.dto.UserDto;

public interface RegistrationService {

    public UserDto register(RegistrationRequest request);
}
