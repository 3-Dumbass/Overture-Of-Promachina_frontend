package dumbass.test.Controller.main;

import dumbass.test.utils.dto.UserDto;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class mainController {

    @GetMapping("/main-form")
    public String main_form(HttpSession session){

        if(session.getAttribute("id") != null){

            UserDto userDto = (UserDto) session.getAttribute("id");

            log.info("session id is " + userDto);
        }
        log.info("mainform");
        return "mainForm";
    }
}
