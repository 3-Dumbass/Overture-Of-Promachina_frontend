package dumbass.test.Controller.login;

import dumbass.test.Controller.login.dto.LoginDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class LoginController {


    @GetMapping("/login-form")
    public String login_form(){

        log.info("login-form");
        return "loginForm";
    }


    @PostMapping("/login")
    public String login_try(LoginDto loginDto){

        log.info("Login Id: " + loginDto.getLoginId());
        log.info("Login Password: " + loginDto.getPassword());





        return "redirect:/main-form";
    }

}
