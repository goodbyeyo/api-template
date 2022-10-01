package template.api.login.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import template.global.jwt.dto.JwtTokenDto;

import java.util.Date;

public class OauthLoginDto {

    @Getter
    @Setter
    public static class Request {
        private String memberType;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private String grantType;

        private String accessToken;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
        private Date accessTokenExpirationTime;

        private String refreshToken;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
        private Date refreshTokenExpirationTime;

        public static Response of(JwtTokenDto jwtTokenDto) {
            return Response.builder()
                    .grantType(jwtTokenDto.getGrantType())
                    .accessToken(jwtTokenDto.getAccessToken())
                    .accessTokenExpirationTime(jwtTokenDto.getAccessTokenExpireTime())
                    .refreshToken(jwtTokenDto.getRefreshToken())
                    .refreshTokenExpirationTime(jwtTokenDto.getRefreshTokenExpireTime())
                    .build();
        }
    }
}
