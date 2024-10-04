package dumbass.test.Controller.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class loginController {


    @GetMapping("/login-form")
    public String login_form(){

        return "loginForm";
    }


    @PostMapping("/login")
    public String login_try(Model model){
        String name = (String) model.getAttribute("username");

        System.out.println(name);
        return "mainForm";
    }

}
