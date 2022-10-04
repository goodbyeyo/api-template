package template.api.login.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import template.global.jwt.dto.JwtTokenDto;

import java.util.Date;

public class OauthLoginDto {

    @Getter
    @Setter
    public static class Request {
        @Schema(description = "소셜 로그인 회원 타입", example = "KAKAO", required = true)
        private String memberType;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {

        @Schema(description = "grantType", example = "Bearer", required = true)
        private String grantType;

        @Schema(description = "accessToken", example = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUu6axWX4uKTRsH6Zt9-1DGQ", required = true)
        private String accessToken;

        @Schema(description = "accessToken 만료시간", example = "2022-10-02 12:58:16", required = true)
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
        private Date accessTokenExpirationTime;

        @Schema(description = "refreshToken", example = "efTRkOn40dLcW1StSjokPJx5ttSjokPJx5ttSjokPJx5twog7eA", required = true)
        private String refreshToken;

        @Schema(description = "refreshToken 만료시간", example = "2022-10-02 12:58:16", required = true)
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
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
