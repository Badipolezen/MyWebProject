package lastproject.lastdelivery.web.filters;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class nameFilter implements Filter {


        @Override

        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                             FilterChain filterChain) throws  IOException, ServletException {

            HttpServletRequest request = (HttpServletRequest) servletRequest;

            HttpServletResponse response = (HttpServletResponse) servletResponse;

            request.getSession().setAttribute("username","username");
            filterChain.doFilter(request, response);
        }
}
