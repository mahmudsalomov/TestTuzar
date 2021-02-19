//package Laboratoriya.uchun.Laboratoriya.controller;
//
//import Laboratoriya.uchun.Laboratoriya.model.UserApp;
//import Laboratoriya.uchun.Laboratoriya.repository.UserAppRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class RegisterController {
//
//    private final PasswordEncoder passwordEncoder;
//    @Autowired
//    private UserAppRepository userAppRepository;
//
//    public RegisterController(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @GetMapping("/register")
//    public String register(Model model){
//        model.addAttribute("user", new UserApp());
//        return "register";
//    }
//    @PostMapping("/register")
//    public String register(UserApp user){
//        user.setRole("USER");
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userAppRepository.save(user);
//        return "register";
//    }
//}
