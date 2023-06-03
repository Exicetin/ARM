package v2.controllers;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import v2.domain.Auth;
import v2.repository.AuthRepository;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("resources/templates/")
@RequiredArgsConstructor
public class LoginController {

    @Autowired
    private AuthRepository authRepository;

    @GetMapping("/auth")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("auth");
        mav.addObject("auth_form");
        System.out.println("AUTH");
        return mav;
    }

    @RequestMapping(value = "/login", method =  RequestMethod.POST)
    public String login(@RequestParam String login, @RequestParam String password,
            HttpSession session, ModelAndView model) {
        System.out.println("LOGIN");
        Auth user = authRepository.findBylogin(login);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            return "redirect:/order_list";
        } else {
            model.addObject("error", "Invalid login or password!");
            return "login";
        }
    }

//    @PostMapping("/login")
//    public String login(@RequestParam String login, @RequestParam String password,
//                        HttpSession session, ModelAndView model) {
//        Auth user = authRepository.findBylogin(login);
//        if (user != null && user.getPassword().equals(password)) {
//            session.setAttribute("user", user);
//            return "redirect:/dashboard";
//        } else {
//            model.addObject("error", "Invalid login or password!");
//            return "login";
//        }
//    }
}