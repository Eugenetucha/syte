package com.syte.syte.Controller;


import com.syte.syte.Model.Entity.User;
import com.syte.syte.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainPageController {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/main_page")
    public String main_page() {
        return "/main_page";
    }


}
