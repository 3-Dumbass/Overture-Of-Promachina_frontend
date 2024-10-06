package dumbass.test.Controller.signup;

import dumbass.test.dto.SignupDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Controller
public class signupController {


    @GetMapping("/signup-form")
    public String signupForm() {

        log.info("signupForm");
        return "signupForm";
    }


    @PostMapping("/loginId-duplicate")
    public Boolean loginIdDuplicateCheck(String loginId){

        log.info("loginId: " + loginId);

        SignupDto signupDto = new SignupDto(null,null,null);
        signupDto.setLogin_id(loginId);

        String url = "http://localhost:8081/api/sign-up/login-id";
        RestTemplate restTemplate = new RestTemplate();
        Boolean result = restTemplate.postForEntity(url, signupDto, Boolean.class).getBody();

        log.info("loginId-duplicate-result: " + result);
        return result;
    }


    @PostMapping("/nickname-duplicate")
    public Boolean nicknameDuplicateCheck(String nickname){

        log.info("nickname: " + nickname);

        SignupDto signupDto = new SignupDto(null,null,null);
        signupDto.setNickname(nickname);

        String url = "http://localhost:8081/api/sign-up/nickname";
        RestTemplate restTemplate = new RestTemplate();
        Boolean result = restTemplate.postForEntity(url, signupDto, Boolean.class).getBody();

        log.info("loginId-duplicate-result: " + result);
        return result;
    }


    @PostMapping("/signup")
    public String signup_check(SignupDto signupDto){
        String url = "http://localhost:8081/api/sign-up/save";

        log.info("signup_nickname: " + signupDto.getNickname());
        log.info("signup_loginId: " + signupDto.getLogin_id());
        log.info("signup_password: " + signupDto.getPassword());

        RestTemplate restTemplate = new RestTemplate();
        Boolean result = restTemplate.postForEntity(url, signupDto, Boolean.class).getBody();

        if (result){
            return "mainForm";
        }
        else{
            return "signupForm";
        }
    }
}
