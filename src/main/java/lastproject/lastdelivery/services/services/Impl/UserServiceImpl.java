package lastproject.lastdelivery.services.services.Impl;


import lastproject.lastdelivery.data.User;
import lastproject.lastdelivery.repositories.RoleRepository;
import lastproject.lastdelivery.repositories.UserRepository;
import lastproject.lastdelivery.services.models.UserServiceModel;
import lastproject.lastdelivery.services.models.UsersServiceModel;
import lastproject.lastdelivery.services.services.RoleService;
import lastproject.lastdelivery.services.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl  implements UserService
{
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;

private final BCryptPasswordEncoder bCryptPasswordEncoder ;

@Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService, ModelMapper modelMapper, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.modelMapper = modelMapper;
    this.roleRepository = roleRepository;

    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public List<UsersServiceModel> getAll() {
        return this.userRepository.findAll().
                stream()
                .map(tr->this.modelMapper.map(tr, UsersServiceModel.class)).
                        collect(Collectors.toList());
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void changeRole(String username) {


            User user=this.userRepository.findByUsername(username);
            if(user.getAuthorities().contains(roleRepository.findByAuthority("GUEST"))) {

                user.setAuthorities(new HashSet<>(Set.of(this.roleRepository.findByAuthority("USER"))));

            }

            if(user.getAuthorities().contains(roleRepository.findByAuthority("USER"))) {

                user.setAuthorities(new HashSet<>(Set.of(this.roleRepository.findByAuthority("GUEST"))));

            }
            userRepository.saveAndFlush(user);
        }


    }



