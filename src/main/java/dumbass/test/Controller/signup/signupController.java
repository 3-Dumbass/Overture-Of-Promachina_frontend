package dumbass.test.Controller.signup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class signupController {


    @PostMapping
    public Boolean loginIdDuplicateCheck(String loginId){

        return true;
    }


    @PostMapping
    public Boolean nicknameDuplicateCheck(String nickname){

        return true;
    }
}
