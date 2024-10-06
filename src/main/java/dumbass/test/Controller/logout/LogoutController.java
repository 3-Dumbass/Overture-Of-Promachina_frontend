package dumbass.test.Controller.logout;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
public class LogoutController {


    @PostMapping("/logout")
    public ResponseEntity<Boolean> logout(HttpSession session){

        session.invalidate();

        return ResponseEntity.ok(true);
    }
}
