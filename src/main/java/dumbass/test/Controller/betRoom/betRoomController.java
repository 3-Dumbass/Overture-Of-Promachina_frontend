package dumbass.test.Controller.betRoom;

import dumbass.test.dto.SessionDto;
import dumbass.test.dto.UserDto;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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


    @GetMapping("/session-room-id")
    public ResponseEntity<SessionDto> session_room_id(HttpSession session){

        SessionDto sessionDto = new SessionDto(null, null);
        sessionDto.setRoom_id((Long) session.getAttribute("room_id"));

        return ResponseEntity.ok(sessionDto);
    }
}
