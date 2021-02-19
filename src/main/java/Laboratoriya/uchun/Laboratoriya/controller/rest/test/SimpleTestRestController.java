package Laboratoriya.uchun.Laboratoriya.controller.rest.test;

import Laboratoriya.uchun.Laboratoriya.component.CustomUserDetailsService;
import Laboratoriya.uchun.Laboratoriya.controller.rest.common.CommonRestController;
import Laboratoriya.uchun.Laboratoriya.generator.TestEngine;
import Laboratoriya.uchun.Laboratoriya.model.user.User;
import Laboratoriya.uchun.Laboratoriya.repository.SimpleTestRepository;
import Laboratoriya.uchun.Laboratoriya.service.test.TestService;
import Laboratoriya.uchun.Laboratoriya.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test/api")
public class SimpleTestRestController {

    @Autowired
    private SimpleTestRepository simpleTestRepository;
    @Autowired
    private TestService testService;

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public ResponseEntity test(){
        TestEngine testEngine=new TestEngine(testService,userService);

//        System.out.println(testEngine.one());

        return ResponseEntity.ok(testEngine.one());
    }

    @PostMapping("/check")
    public ResponseEntity check(@RequestParam String choice, @RequestParam long id){
        TestEngine testEngine=new TestEngine(testService,userService);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        boolean bool=testEngine.checkAnswer(choice, id);
        if (bool){
            System.out.println(userService.addRating(authentication.getName(),testEngine.checkAmount(id)));
        }
//        System.out.println(user);
//        if (bool){
//
//        }
        return ResponseEntity.ok(bool);
    }

}
