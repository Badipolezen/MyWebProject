package lastproject.lastdelivery.web.view.controlers;


import lastproject.lastdelivery.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class HomeIndex extends BaseController {

    @GetMapping("/")
    public String index(){
        return "/index";
    }

    @GetMapping("/home")
    public ModelAndView index(ModelAndView modelAndView, HttpSession session) {
        modelAndView.setViewName("home");
        modelAndView.addObject("username", session.getAttribute("username"));

        return modelAndView;
    }



}
