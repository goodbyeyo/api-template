package template.external.oauth.kakao.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import template.external.oauth.kakao.dto.KaKaoUserInfoResponseDto;

@FeignClient(url = "https:/kapi.kakao.com", name = "KaKaoUserInfoClient")
public interface KaKaoUserInfoClient {

    @GetMapping(value = "/v2/user/me", consumes = "application/json")
    KaKaoUserInfoResponseDto getKaKaoUserInfo(@RequestHeader("Content-type") String contentType,
                                              @RequestHeader("Authorization") String accessToken);

}
