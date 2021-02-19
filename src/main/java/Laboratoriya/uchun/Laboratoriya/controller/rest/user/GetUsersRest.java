package Laboratoriya.uchun.Laboratoriya.controller.rest.user;

import Laboratoriya.uchun.Laboratoriya.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetUsersRest {
    private final UserService userService;

    public GetUsersRest(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/all")
    public ResponseEntity getAll(){
        return ResponseEntity.ok(userService.getAll());
    }
}
