package dumbass.test.Controller.gameRoom;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class gameRoomController {

    @GetMapping("/room-list")
    public String main_form(){

        log.info("room");
        return "roomForm";
    }


    @PostMapping("/room-id")
    public String room_id(HttpSession session, Long room_id) {
        session.setAttribute("room_id", room_id);

        return "betRoomForm";
    }
}
