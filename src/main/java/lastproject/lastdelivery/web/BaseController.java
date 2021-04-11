package lastproject.lastdelivery.web;

import lastproject.lastdelivery.services.models.LoginServiceModel;
//import lastproject.lastdelivery.services.models.LoginUserServiceModel;

import javax.servlet.http.HttpSession;

public class BaseController {
    public boolean isAuthenticated(HttpSession session ){
        return session.getAttribute("username")!=null;
    }
    protected String getUsername(HttpSession session) {
        return ((LoginServiceModel) session.getAttribute("username")).getUsername();
    }

}
