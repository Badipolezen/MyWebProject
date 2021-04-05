package lastproject.lastdelivery.services.services;

import lastproject.lastdelivery.services.models.LoginServiceModel;
import lastproject.lastdelivery.services.models.RegisterUserServiceModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {

    void register(RegisterUserServiceModel model) throws Exception;
    void login(LoginServiceModel model) throws Exception;
}
