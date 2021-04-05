package lastproject.lastdelivery.services.services.Impl;

import lastproject.lastdelivery.data.User;
import lastproject.lastdelivery.repositories.RoleRepository;
import lastproject.lastdelivery.repositories.UserRepository;
import lastproject.lastdelivery.services.HashingService;
import lastproject.lastdelivery.services.models.LoginServiceModel;
import lastproject.lastdelivery.services.models.RegisterUserServiceModel;
import lastproject.lastdelivery.services.services.AuthService;
import lastproject.lastdelivery.services.services.AuthValidationService;
import lastproject.lastdelivery.services.services.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class AuthServiceImpl implements AuthService {

private final ModelMapper modelMapper;
private final UserRepository userRepository;
        private final RoleService roleService;
    private final RoleRepository roleRepository;
private final HashingService hashingService;
private final AuthValidationService authValidationService ;

@Autowired
    public AuthServiceImpl(ModelMapper modelMapper, UserRepository userRepository, RoleService roleService, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder, HashingService hashingService, AuthValidationService authValidationService) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.roleRepository = roleRepository;
    this.hashingService = hashingService;
        this.authValidationService = authValidationService;

}


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username);
    }


    @Override
    public void register(RegisterUserServiceModel model) throws Exception {

        if (!authValidationService.isValid(model)) {
            throw new Exception("Invalid credential");
//            return;
        } else {

            User user = this.modelMapper.map(model, User.class);

    if(this.userRepository.count()==0){

        roleService.seedRolesInDb();
        user.setAuthorities(new HashSet<>(this.roleRepository.findAll()));

    }else{
        user.setAuthorities(new HashSet<>(Set.of(this.roleRepository.findByAuthority("USER"))));
    }

    user.setPassword(hashingService.hash(user.getPassword()));
            userRepository.saveAndFlush(user);
        }

    }

    @Override
    public void login(LoginServiceModel model) throws Exception {
        String passwordHash=this.hashingService.hash(model.getPassword());

        if(!userRepository.existsByUsernameAndPassword(model.getUsername(), passwordHash));
            throw new Exception ("invalid User");
    }

}

