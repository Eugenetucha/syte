package com.syte.syte.Controller;

import com.syte.syte.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class FirstPageController {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/first_page")
    public String first_page() {
        return "/first_page";
    }

}
