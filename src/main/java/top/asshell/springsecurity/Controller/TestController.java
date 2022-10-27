package top.asshell.springsecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public String hello (){
        return "hello Spring Security";
    }
    @GetMapping("/index")
    public String index (){
        return "hello Spring Security index";
    }
}
