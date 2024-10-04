package dumbass.test.Controller.login.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class LoginDto {

    private String loginId;
    private String password;
}
