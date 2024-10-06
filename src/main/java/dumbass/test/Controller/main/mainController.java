package dumbass.test.Controller.main;

import dumbass.test.utils.dto.AccountDto;
import dumbass.test.utils.dto.UserDto;
import dumbass.test.utils.linkUrl;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Controller
public class mainController {

    @GetMapping("/main-form")
    public String main_form(Model model, HttpSession session){

        if(session.getAttribute("id") != null){

            UserDto userDto = (UserDto) session.getAttribute("id");
            model.addAttribute("coin", coin_count(userDto));

            log.info("session id is " + userDto);
        }
        log.info("mainform");
        return "mainForm";
    }


    public Long coin_count(UserDto userDto){
        String wallet_api = linkUrl.wallet_api + "/wallet/amount";

        Long coin = 0L;
        for(AccountDto accountDto : userDto.getAccount()) {
            RestTemplate restTemplate = new RestTemplate();
//            Long price = restTemplate.postForEntity(wallet_api, accountDto.getAccountKey(), Long.class).getBody();
//            if(price != null){
//                coin += price;
//            }
        }

        return coin;
    }
}
