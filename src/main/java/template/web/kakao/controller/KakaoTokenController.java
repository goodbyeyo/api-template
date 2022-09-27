package template.web.kakao.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import template.web.kakao.client.KakaoTokenClient;
import template.web.kakao.dto.KakaoTokenDto;

@Controller
@RequiredArgsConstructor
public class KakaoTokenController {

    private final KakaoTokenClient kakaoTokenClient;

    @Value("${kakao.client.id}")
    private String clientId;

    @Value("${kakao.client.secret}")
    private String clientSecret;

    private static final String contentType = "application/x-www-form-urlencoded;charset=utf-8";
    private static final String grantType = "authorization_code";

    @Value("${kakao.client.redirectUrl}")
    private String redirectUrl;

    @GetMapping("/login")
    public String login() {
        return "loginForm";
    }

    @GetMapping("/oauth/kakao/callback")
    public @ResponseBody String loginCallBack(String code) {
        KakaoTokenDto.Request requestDto = KakaoTokenDto.Request.builder()
                .client_id(clientId)
                .client_secret(clientSecret)
                .grant_type(grantType)
                .code(code)
                .redirect_uri(redirectUrl)
                .build();
        KakaoTokenDto.Response kakaoToken = kakaoTokenClient.requestKakaoToken(contentType, requestDto);
        return "kakao token : " + kakaoToken ;
    }
}
