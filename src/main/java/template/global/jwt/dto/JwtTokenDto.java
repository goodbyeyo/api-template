package template.global.jwt.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtTokenDto {

    private String grantType;
    private String accessType;
    private Date accessTokenExpireTime;
    private String refreshToken;
    private Date refreshTokenExpireTime;

}
