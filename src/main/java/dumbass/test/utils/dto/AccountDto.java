package dumbass.test.utils.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AccountDto {
    private Long user_id;
    private String accountKey;
    private String priKey;
}
