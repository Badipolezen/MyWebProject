package lastproject.lastdelivery.web.view.controlers.auth;

import lastproject.lastdelivery.data.User;
import lastproject.lastdelivery.services.models.LoginServiceModel;
import lastproject.lastdelivery.services.models.RegisterUserServiceModel;
import lastproject.lastdelivery.services.services.AuthService;
import lastproject.lastdelivery.web.BaseController;

import lastproject.lastdelivery.web.view.models.UserLoginModel;
import lastproject.lastdelivery.web.view.models.WebUserRegisterModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AuthController extends BaseController {

    private final AuthService authService;
    private final ModelMapper modelMapper;

    public AuthController(AuthService authService, ModelMapper modelMapper) {
        this.authService = authService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/login")
    public String login(HttpSession session) {
        return "login";
    }
//
//    @PostMapping("/login")
//    public String getLoginPage(@RequestParam(required = false) String error, Model model, @ModelAttribute UserLoginModel userLoginModel) throws Exception {
//
//
//        if (error != null) {
//            model.addAttribute("error", "Error");
//
//            return  "/login";
//        }
//
//        return "redirect: /home";
//
//    }

    @PostMapping("/login")
    public String loginConfirm(@ModelAttribute UserLoginModel userLoginModel) throws Exception {

        LoginServiceModel loginServiceModel = this.modelMapper.map(userLoginModel, LoginServiceModel.class);

        try {
            this.authService.login(loginServiceModel);
            return "redirect:/home";

        } catch (Exception ex) {
            return "redirect:/login";
        }
    }


//            return "redirect:/home";
//        } catch (Exception ex) {
//            return "redirect:/users/login";
//        }
//    }


    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@ModelAttribute WebUserRegisterModel model) throws Exception {


        if (!model.getPassword().equals(model.getConfirmPassword())) {

            return "register";
        } else {
            RegisterUserServiceModel serviceModel = this.modelMapper.map(model, RegisterUserServiceModel.class);
            this.authService.register(serviceModel);
            return "redirect:/login";


        }
    }
}



