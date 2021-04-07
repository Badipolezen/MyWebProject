package lastproject.lastdelivery.web.view.controlers;

import lastproject.lastdelivery.services.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/all")
    public String trackOrder(){
        return "users/allusers";
    }

    @GetMapping("/profile")

    private String details() {
        return "users/profile";
    }

}