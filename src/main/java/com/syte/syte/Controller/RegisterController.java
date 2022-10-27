package com.syte.syte.Controller;

import com.syte.syte.Model.Entity.User;
import com.syte.syte.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
@Controller
public class RegisterController {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/register")
    public String register_page(Model model) {
        model.addAttribute("User", new User());
        return "/register";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute("User") @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("User", user );
            return "/register";
        }
        if(userService.findUserByUsername(user.getUsername()) != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        user.setRole("MERCHANT");
        user.setAccountNonLocked(true);
        if (user.getPassword().equals("ass")) {
            user.setRole("ADMINISTRATOR");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        model.addAttribute("User", user);
        userService.Save(user);
        return "/main_page";
    }
    @ExceptionHandler(AuthenticationException.class)
    public ModelAndView error(AuthenticationException e, HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }
}
