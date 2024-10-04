package dumbass.test.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDto {

    private Long user_id;
    private String nickname;
    private String image_url;
    private Long chip;
    private List<AccountDto> account;

    public UserDto(Long user_id, String nickname, String image_url, Long chip, List<AccountDto> account) {
        this.user_id = user_id;
        this.nickname = nickname;
        this.image_url = image_url;
        this.chip = chip;
        this.account = account;
    }
}