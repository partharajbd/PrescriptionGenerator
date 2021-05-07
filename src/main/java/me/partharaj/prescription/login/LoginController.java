package me.partharaj.prescription.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("auth/login")
public class LoginController {

    @GetMapping
    public String login(){
        return "auth/login";
    }

}
