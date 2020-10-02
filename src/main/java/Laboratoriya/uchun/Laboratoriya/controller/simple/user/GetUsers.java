package Laboratoriya.uchun.Laboratoriya.controller.simple.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetUsers {

    @GetMapping("/all/all")
    public String getAll(){
        return "user/get_users";
    }

}
