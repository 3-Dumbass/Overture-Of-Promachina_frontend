package dumbass.test.Controller.signup;

import com.fasterxml.jackson.databind.util.JSONPObject;
import dumbass.test.Controller.signup.dto.SignupDto;
import dumbass.test.utils.Utils;
import dumbass.test.utils.dto.AccountDto;
import dumbass.test.utils.dto.WalletDto;
import dumbass.test.utils.linkUrl;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.JsonParser;
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

        SignupDto signupDto = new SignupDto(null,null,null, null);
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

        SignupDto signupDto = new SignupDto(null,null,null, null);
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
        signupDto = restTemplate.postForEntity(url, signupDto, SignupDto.class).getBody();

        if (account_add(signupDto)){
            return "mainForm";
        }
        else{
            return "signupForm";
        }
    }

    public Boolean account_add(SignupDto signupDto){

        String wallet_url = linkUrl.wallet_api + "/wallet/new";
        RestTemplate restTemplate = new RestTemplate();

        String json_text = restTemplate.getForObject(wallet_url, String.class);

        JSONObject obj = new JSONObject(json_text);

        String account_url = "http://localhost:8081/api/account/add";
        AccountDto accountDto = new AccountDto(signupDto.getUser_id(), obj.getString("address"), obj.getString("passwd"));
        Boolean result = restTemplate.postForEntity(account_url, accountDto, Boolean.class).getBody();

        return result;
    }

}
