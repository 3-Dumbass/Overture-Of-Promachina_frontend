package dumbass.test.Controller.main;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class mainController {

    @GetMapping("/main-form")
    public String main_form(){

        log.info("mainform");
        return "mainForm";
    }
}
