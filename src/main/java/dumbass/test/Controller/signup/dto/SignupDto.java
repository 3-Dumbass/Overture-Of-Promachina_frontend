package dumbass.test.Controller.signup.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SignupDto {

    private Long user_id;
    private String nickname;
    private String login_id;
    private String password;
}
