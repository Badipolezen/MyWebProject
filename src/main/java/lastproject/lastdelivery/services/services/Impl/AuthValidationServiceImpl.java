package lastproject.lastdelivery.services.services.Impl;

import lastproject.lastdelivery.repositories.UserRepository;
import lastproject.lastdelivery.services.models.RegisterUserServiceModel;
import lastproject.lastdelivery.services.services.AuthValidationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthValidationServiceImpl implements AuthValidationService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public AuthValidationServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository, ModelMapper modelMapper) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;

    }

    @Override
    public boolean isValid(RegisterUserServiceModel user) {
        return this.isPasswordIsValid(user.getPassword(), user.getConfirmPassword())
                && this.isUsernameFree(user.getUsername());
    }


    private boolean isPasswordIsValid(String password, String confirmPassword) {

        return password.equals(confirmPassword);
    }

    private boolean isUsernameFree(String username) {
        return !userRepository.existsByUsername(username);

    }


}


