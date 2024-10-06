package dumbass.test.Controller.login;

import dumbass.test.Controller.login.dto.LoginDto;
import dumbass.test.utils.dto.SessionDto;
import dumbass.test.utils.dto.UserDto;
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


        UserDto user_data = login_api(loginDto);
        if(user_data != null){

            user_data = user_api(user_data);

            session.setAttribute("id", user_data);

            return "redirect:/main-form";
        }
        else{
            return "redirect:/login-form";
        }
    }


    /** 로그인 시 아이디 확인 */
    public UserDto login_api(LoginDto loginDto){
        String url = "http://localhost:8081/api/login/login";

        RestTemplate restTemplate = new RestTemplate();
        UserDto userDto = restTemplate.postForEntity(url, loginDto, UserDto.class).getBody();

        return userDto;
    }


    /** api에서 User정보 조회 */
    public UserDto user_api(UserDto userDto){

        RestTemplate restTemplate = new RestTemplate();

        UserDto user_data;
        String image_url = "http://localhost:8081/api/user/image-select";
        user_data = restTemplate.postForEntity(image_url, userDto, UserDto.class).getBody();

        String chip_url = "http://localhost:8081/api/chip/select";
        user_data = restTemplate.postForEntity(chip_url, user_data, UserDto.class).getBody();

        String account_url = "http://localhost:8081/api/account/select";
        user_data = restTemplate.postForEntity(account_url, user_data, UserDto.class).getBody();

        return user_data;
    }


    @GetMapping("/session")
    public ResponseEntity<SessionDto> session(HttpSession session){

        log.info("session Call");
        UserDto userDto = (UserDto) session.getAttribute("id");
        return ResponseEntity.ok(new SessionDto(userDto, null));
    }


}
