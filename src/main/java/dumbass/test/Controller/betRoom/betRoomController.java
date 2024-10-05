package dumbass.test.Controller.betRoom;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class betRoomController {
    @GetMapping("/betting-room")
    public String main_form(){

        log.info("betting room");
        return "betRoomForm";
    }
}
