package com.syte.syte.Controller;

import com.syte.syte.Model.Entity.User;
import com.syte.syte.Model.Entity.User_options;
import com.syte.syte.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
@Controller
public class OfficeController {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder encoder;
    @GetMapping("/office")
    public ModelAndView office_page(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findUserByUsername(principal.getName());
        modelAndView.addObject("User", user);
        modelAndView.addObject("User_options", new User());
        return modelAndView;
    }

    @PostMapping("/office")
    public ModelAndView office_options(@ModelAttribute("User_options") User_options user_options, Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findUserByUsername(principal.getName());
        user.setCountry(user_options.getCountry());
        user.setEmail(user_options.getEmail());
        user.setTelephone_number(user_options.getTelephone_number());
        userService.Save(user);
        modelAndView.addObject("User", user);
        modelAndView.addObject("User_options", new User());
        return modelAndView;
    }

    @PutMapping("/office")
    public String office_change(Principal principal, Model model) {
        User user = userService.findUserByUsername(principal.getName());
        user.setCountry(null);
        user.setEmail(null);
        user.setTelephone_number(null);
        userService.Save(user);
        model.addAttribute("User", user);
        model.addAttribute("User_options", new User());
        return "/office";
    }
}
