package dumbass.test.Controller.login;

import dumbass.test.Controller.login.dto.LoginDto;
import dumbass.test.dto.SessionDto;
import dumbass.test.dto.UserDto;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Controller
public class LoginController {


    @GetMapping("/login-form")
    public String login_form(){

        log.info("login-form");
        return "loginForm";
    }


    @PostMapping("/login")
    public String login_try(Model model, LoginDto loginDto, HttpSession session){

        log.info("Login Id: " + loginDto.getLoginId());
        log.info("Login Password: " + loginDto.getPassword());


        session.setAttribute("id", login_api(loginDto));
        UserDto a = (UserDto) session.getAttribute("id");

        log.info("session: " + a);

        return "redirect:/main-form";
    }


    /** 로그인 api 연결부 */
    public UserDto login_api(LoginDto loginDto){
        String url = "http://localhost:8081/login/login";

        RestTemplate restTemplate = new RestTemplate();
        UserDto userDto = restTemplate.postForEntity(url, loginDto, UserDto.class).getBody();
        return userDto;
    }


    @GetMapping("/session")
    public ResponseEntity<SessionDto> session(HttpSession session){

        log.info("session Call");
        UserDto userDto = (UserDto) session.getAttribute("id");
        return ResponseEntity.ok(new SessionDto(userDto, null));
    }


}
