package dumbass.test.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SignupDto {

    private String nickname;
    private String login_id;
    private String password;
}
