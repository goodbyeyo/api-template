package template.global.jwt.service;

import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import template.domain.member.constant.Role;
import template.global.jwt.constant.TokenType;
import template.global.jwt.dto.JwtTokenDto;

import java.util.Date;

@Slf4j
@RequiredArgsConstructor
public class TokenManager {

    private final String accessTokenExpirationTime;
    private final String refreshTokenExpirationTime;
    private final String tokenSecret;

    public JwtTokenDto createJwtTokenDto(Long memberId, Role role, String refreshToken) {

        return null;
    }

    public Date createAccessTokenExpireTime() {
        return new Date(System.currentTimeMillis() + Long.parseLong(accessTokenExpirationTime));
    }

    public Date createRefreshTokenExpireTime() {
        return new Date(System.currentTimeMillis() + Long.parseLong(refreshTokenExpirationTime));
    }

    public String createAccessToken(Long memberId, Role role, Date expirationTime) {
//        Jwts.builder()
//                .setSubject(TokenType.ACCESS.name())
//                .setIssuedAt(new Date())
//                .setExpiration(expirationTime)
//                .claim("memberId", memberId)
//                .build();
        return null;
    }

}

