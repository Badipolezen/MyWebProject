package lastproject.lastdelivery.services.services.Impl;


import lastproject.lastdelivery.repositories.UserRepository;
import lastproject.lastdelivery.services.models.UsersServiceModel;
import lastproject.lastdelivery.services.services.RoleService;
import lastproject.lastdelivery.services.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl  implements UserService
{
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final ModelMapper modelMapper;

private final BCryptPasswordEncoder bCryptPasswordEncoder ;

    public UserServiceImpl(UserRepository userRepository, RoleService roleService, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public List<UsersServiceModel> getAll() {
        return this.userRepository.findAll().
                stream()
                .map(tr->this.modelMapper.map(tr, UsersServiceModel.class)).
                        collect(Collectors.toList());
    }
    }

