package dumbass.test.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SessionDto {
    private UserDto user;
    private Long room_id;
}
