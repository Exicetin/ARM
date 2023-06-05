package v2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {
    @GetMapping(value = "/")
    public ModelAndView showIndex(){
        ModelAndView mav = new ModelAndView("orders_list");
        return mav;
    }
}
