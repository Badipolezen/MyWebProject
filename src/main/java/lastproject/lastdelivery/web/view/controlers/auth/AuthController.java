package lastproject.lastdelivery.web.view.controlers.auth;

import lastproject.lastdelivery.services.models.LoginUserServiceModel;
import lastproject.lastdelivery.services.models.RegisterUserServiceModel;
import lastproject.lastdelivery.services.services.AuthService;
import lastproject.lastdelivery.web.BaseController;
import lastproject.lastdelivery.web.view.models.UserRegisterModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class AuthController extends BaseController {

    private final AuthService authService;
    private final ModelMapper modelMapper;

    public AuthController(AuthService authService, ModelMapper modelMapper) {
        this.authService = authService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/login")
    public String login(HttpSession session ) {
        return "login";
    }

    @PostMapping("/login")
    public String getLoginPage(@RequestParam(required = false) String error, Model model, HttpSession session) {
        if (error != null) {
            model.addAttribute("error", "Error");

            return  "/login";
        }
        return "redirect: /home";


    }




    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@ModelAttribute UserRegisterModel model) throws Exception {


        if (!model.getPassword().equals(model.getConfirmPassword())) {
            return "register";
        }

        RegisterUserServiceModel serviceModel=this.modelMapper.map(model, RegisterUserServiceModel.class);
        this.authService.register(serviceModel);
        return "redirect:/login";

    }
}
