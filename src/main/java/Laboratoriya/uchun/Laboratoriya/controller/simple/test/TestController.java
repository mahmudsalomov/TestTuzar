package Laboratoriya.uchun.Laboratoriya.controller.simple.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/test")
    public String test_main(){
        return "tests/tests-main";
    }

    @GetMapping("/test/test-process")
    public String process(){
        return "tests/tests-process";
    }

    @GetMapping("/test/result")
    public String result(){
        return "tests/tests-result";
    }

}
