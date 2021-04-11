package lastproject.lastdelivery.web.mvc;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class MVControler {
        @GetMapping(value = "/username")
        @ResponseBody
        public String currentUserName(Authentication authentication) {

                if (authentication != null)
                        return authentication.getName();
                else
                        return "";
        }
}
