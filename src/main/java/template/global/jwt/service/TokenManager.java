package template.global.jwt.service;

import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import template.domain.member.constant.Role;
import template.global.error.ErrorCode;
import template.global.error.exception.AuthenticationException;
import template.global.jwt.constant.GrantType;
import template.global.jwt.constant.TokenType;
import template.global.jwt.dto.JwtTokenDto;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor
public class TokenManager {

    private final String accessTokenExpirationTime;
    private final String refreshTokenExpirationTime;
    private final String tokenSecret;

    public JwtTokenDto createJwtTokenDto(Long memberId, Role role) {
        String accessToken = createAccessToken(memberId, role, createAccessTokenExpireTime());
        String refreshToken = createRefreshToken(memberId, createRefreshTokenExpireTime());
        return JwtTokenDto.builder()
                .grantType(GrantType.BEARER.getType())
                .accessToken(accessToken)
                .accessTokenExpireTime(createAccessTokenExpireTime())
                .refreshToken(refreshToken)
                .refreshTokenExpireTime(createRefreshTokenExpireTime())
                .build();
    }

    public Date createAccessTokenExpireTime() {
        return new Date(System.currentTimeMillis() + Long.parseLong(accessTokenExpirationTime));
    }

    public Date createRefreshTokenExpireTime() {
        return new Date(System.currentTimeMillis() + Long.parseLong(refreshTokenExpirationTime));
    }

    public String createAccessToken(Long memberId, Role role, Date expirationTime) {
        return Jwts.builder()
                .setSubject(TokenType.ACCESS.name())
                .setIssuedAt(new Date())
                .setExpiration(expirationTime)
                .claim("memberId", memberId)
                .claim("role", role)
                .signWith(SignatureAlgorithm.HS512, tokenSecret.getBytes(StandardCharsets.UTF_8))
                .setHeaderParam("typ", "JWT")
                .compact();
    }

    public String createRefreshToken(Long memberId, Date expirationTime) {
        return Jwts.builder()
                .setSubject(TokenType.REFRESH.name())
                .setIssuedAt(new Date())
                .setExpiration(expirationTime)
                .claim("memberId", memberId)
                .signWith(SignatureAlgorithm.HS512, tokenSecret.getBytes(StandardCharsets.UTF_8))
                .setHeaderParam("typ", "JWT")
                .compact();
    }

    public void validateToken(String token) {
        try {
            Jwts.parser()
                .setSigningKey(tokenSecret.getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token);
        } catch (ExpiredJwtException e) {
            log.error("validate token failed", e);
            throw new AuthenticationException(ErrorCode.TOKEN_EXPIRED);
        } catch (Exception e) {
            log.error("not valid token", e);
            throw new AuthenticationException(ErrorCode.NOT_VALID_TOKEN);
        }
    }

    public Claims getTokenClaims(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(tokenSecret.getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            log.error("not valid token", e);
            throw new AuthenticationException(ErrorCode.NOT_VALID_TOKEN);
        }
        return claims;
    }
}

