package dumbass.test.utils.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WalletDto {
    private String walletAddress;
    private String privateKey;
}
