package lastproject.lastdelivery.web.mvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MVControler {


        @RequestMapping(value = "/home", method = RequestMethod.GET)

        public String currentUserName(Principal principal) {
            return principal.getName();
        }

    }

