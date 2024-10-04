package dumbass.test.Controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class loginController {


    @GetMapping("/login-form")
    public String login_form(){

        return "login";
    }


    @PostMapping("/login")
    public String login_try(Model model){
        String name = (String) model.getAttribute("username");

        System.out.println(name);
        return "mainForm";
    }

}
