package Laboratoriya.uchun.Laboratoriya.controller.simple.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/ratings")
    public String ratings(){
        return "user/rating";
    }

    @GetMapping("/register")
    public String register(){
        return "user/register";
    }

    @GetMapping("/success")
    public String success(){
        return "user/success";
    }

    @GetMapping("/user")
    public String user(){
        return "user/user-main";
    }

}
