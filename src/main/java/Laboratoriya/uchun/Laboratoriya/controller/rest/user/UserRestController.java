package Laboratoriya.uchun.Laboratoriya.controller.rest.user;

import Laboratoriya.uchun.Laboratoriya.model.user.User;
import Laboratoriya.uchun.Laboratoriya.model.user.UserRegistrationFields;
import Laboratoriya.uchun.Laboratoriya.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("rating")
    public ResponseEntity getRating(){
        String username=SecurityContextHolder.getContext().getAuthentication().getName();
        String role=SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString();
        if (role.equals("USER")){
            return ResponseEntity.ok(userService.getRating(username));
        }
        return ResponseEntity.ok("0");

    }

    @GetMapping("ratings")
    public ResponseEntity getRatings(){
        return ResponseEntity.ok(userService.ratings());
    }


    @GetMapping("user")
    public ResponseEntity user(){
        return ResponseEntity.ok("Bu user sahifasi");
    }

    @PostMapping("register")
    public ResponseEntity create(@RequestBody UserRegistrationFields userRegistrationFields){

        if (userService.existsByUsername(userRegistrationFields.getUsername())){
            return new ResponseEntity("Username oldindan mavjud!", HttpStatus.BAD_REQUEST);
        }

        if (!checkPassword(userRegistrationFields.getPassword())){
            return new ResponseEntity("Parol uzunligi 4 ta belgidan kam", HttpStatus.BAD_REQUEST);
        }
        User user=new User();
        user.setUsername(userRegistrationFields.getUsername());
        user.setPassword(userRegistrationFields.getPassword());
        user.setFirstName(userRegistrationFields.getFirstName());
        user.setLastName(userRegistrationFields.getLastName());
        user.setEmail(userRegistrationFields.getEmail());
        user.setRating((long) 0);
        return ResponseEntity.ok(userService.save(user));

    }


    private boolean checkPassword(String password){
        return password.length() >= 4;
    }

}
