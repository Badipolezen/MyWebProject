package lastproject.lastdelivery.web.view.controlers;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class HandleAllException {

    @ExceptionHandler(Throwable.class)
    public ModelAndView handleException(Throwable exception) {
        ModelAndView modelAndView = new ModelAndView("error.html");
        modelAndView.addObject("message", exception.getMessage());

        return modelAndView;

    }
}
