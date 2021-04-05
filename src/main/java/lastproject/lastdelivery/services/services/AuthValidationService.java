package lastproject.lastdelivery.services.services;

import lastproject.lastdelivery.repositories.UserRepository;
import lastproject.lastdelivery.services.models.RegisterUserServiceModel;

public interface AuthValidationService {

    boolean isValid(RegisterUserServiceModel user);

}
