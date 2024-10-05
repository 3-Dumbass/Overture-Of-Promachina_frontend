package dumbass.test.Controller.betRoom;

import dumbass.test.dto.UserDto;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class betRoomController {
    @GetMapping("/betting-room")
    public String main_form(HttpSession session){
        UserDto userDto = (UserDto) session.getAttribute("id");
        if(userDto==null||userDto.getUser_id()==null){
            return "loginForm";
        }
        log.info("betting room");
        return "betRoomForm";
    }
}
