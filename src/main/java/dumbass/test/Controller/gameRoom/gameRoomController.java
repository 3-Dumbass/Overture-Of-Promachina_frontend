package dumbass.test.Controller.gameRoom;

import dumbass.test.dto.UserDto;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class gameRoomController {

    @GetMapping("/room-list")
    public String main_form(HttpSession session){
        UserDto userDto = (UserDto) session.getAttribute("id");
        if(userDto==null||userDto.getUser_id()==null){
            return "redirect:/login-form";
        }
        log.info("room");
        return "roomForm";
    }


    @GetMapping("/join/room/{room_id}")
    public String betting_room_id(HttpSession session, @PathVariable("room_id") Long room_id) {
        session.setAttribute("room_id", room_id);

        return "redirect:/betting-room";
    }
}
