package lastproject.lastdelivery.web.api.controlers;

import lastproject.lastdelivery.services.models.UsersServiceModel;
import lastproject.lastdelivery.services.services.UserService;
import lastproject.lastdelivery.web.api.models.UserResponceModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserApiController {
    private final UserService userService;
    private final ModelMapper modelMapper;
@Autowired
    public UserApiController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/api/users")

    public List<UserResponceModel> allUser () {
        return userService.getAll()
                .stream()
                .map(order -> this.modelMapper.map(order, UserResponceModel.class)).collect(Collectors.toList());


    }
}
