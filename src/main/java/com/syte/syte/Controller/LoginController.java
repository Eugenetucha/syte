package com.syte.syte.Controller;

import com.syte.syte.Model.Entity.User;
import com.syte.syte.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/login")
    public String login_page(Model model) {
        model.addAttribute("User", new User());
        return "/login";
    }
}
