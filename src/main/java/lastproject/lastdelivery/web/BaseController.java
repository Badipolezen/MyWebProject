package lastproject.lastdelivery.web;

import lastproject.lastdelivery.web.view.models.UserLoginModel;


import javax.servlet.http.HttpSession;

public class BaseController {
    public boolean isAuthenticated(HttpSession session ){
        return session.getAttribute("username")!=null;
    }
    protected String getUsername(HttpSession session) {
        return ((UserLoginModel) session.getAttribute("username")).getUsername();
    }

}
