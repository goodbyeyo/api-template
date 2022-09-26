package template.api.login.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import template.api.login.dto.OauthLoginDto;
import template.domain.member.constant.MemberType;
import template.external.oauth.kakao.service.SocialLoginApiServiceFactory;
import template.external.oauth.model.OAuthAttributes;
import template.external.oauth.service.SocialLoginApiService;

@Slf4j
@Service
@Transactional
public class OauthLoginService {

    public OauthLoginDto.Response oauthLogin(String accessToken, MemberType memberType) {
        SocialLoginApiService socialLoginApiService = SocialLoginApiServiceFactory.getSocialLoginApiServices(memberType);
        OAuthAttributes userInfo = socialLoginApiService.getUserInfo(accessToken);
        log.info("userInfo = {}", userInfo);

        return OauthLoginDto.Response.builder().build();


    }
}
