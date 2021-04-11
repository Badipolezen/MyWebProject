package lastproject.lastdelivery.web.view.controlers;

import lastproject.lastdelivery.data.Role;
import lastproject.lastdelivery.data.User;
import lastproject.lastdelivery.repositories.RoleRepository;
import lastproject.lastdelivery.repositories.UserRepository;
import lastproject.lastdelivery.services.services.UserService;
import lastproject.lastdelivery.web.view.models.UserRegisterModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller


@RequestMapping("/users")
public class UserController {

    private final ModelMapper modelMapper;
    private final UserService userService;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
@Autowired
    public UserController(ModelMapper modelMapper, UserService userService, RoleRepository roleRepository, UserRepository userRepository) {
        this.modelMapper = modelMapper;
    this.userService = userService;
    this.roleRepository = roleRepository;
    this.userRepository = userRepository;
}

    @GetMapping("/all")
    public String trackOrder(){
        return "users/allusers";
    }

    @GetMapping("/change")
    public String changeRole(){
        return "users/allusers";
    }

    @PostMapping("/change/{username}")


    public String orderUpdate(@PathVariable String username) {
//        UserRegisterModel registerModel = this.modelMapper.map(changeRole, UserRegisterModel.class);
        User user = this.userService.findByUsername(username);

        if (user.getAuthorities().contains(roleRepository.findByAuthority("GUEST"))) {

            user.setAuthorities(new HashSet<>(Set.of(this.roleRepository.findByAuthority("USER"))));
            this.userRepository.saveAndFlush(user);
        }else {


            if (user.getAuthorities().contains(roleRepository.findByAuthority("USER"))) {

                user.setAuthorities(new HashSet<>(Set.of(this.roleRepository.findByAuthority("GUEST"))));
                this.userRepository.saveAndFlush(user);

            }

        }

        return "redirect:/users/all";
    }

    @GetMapping("/profile")

    private String details() {
        return "users/profile";
    }

}