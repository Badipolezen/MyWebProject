package lastproject.lastdelivery.web.view.controlers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeIndex {

    @GetMapping("/")
    public String index(){
        return "home";
    }


    @GetMapping("/home")
        public String home(){
        return "home";
    }


    @GetMapping("/koko")

    public String getMapPage(Model model){
        String message = "Hi JS!";
        model.addAttribute("message", message);
        return "index";
    }



}
