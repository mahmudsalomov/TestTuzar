package Laboratoriya.uchun.Laboratoriya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    @PostMapping("/admin")
    public String admin(){
        return "admin/admin";
    }


}
