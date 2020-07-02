package me.cheonhwa.bookyouthspace.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("/hello")
    public String hello(){
        return "account/hello";
    }

}
