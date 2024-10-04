package Controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class loginController {

    @PostMapping("/login")
    public String login_try(Model model){
        String name = (String) model.getAttribute("username");

        System.out.println(name);
        return "main";
    }

}
