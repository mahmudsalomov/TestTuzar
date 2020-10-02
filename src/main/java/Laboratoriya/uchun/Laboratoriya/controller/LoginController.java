package Laboratoriya.uchun.Laboratoriya.controller;

import Laboratoriya.uchun.Laboratoriya.model.user.User;
import Laboratoriya.uchun.Laboratoriya.service.user.UserService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    @PostMapping("/login")
    public String login(){


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            User loggedInUser = userService.findbyusername(auth.getName());
            /* The user is logged in :) */
            return "redirect:/";
        }
        return "login";
    }

}
