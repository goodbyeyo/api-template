package template.external.oauth.kakao.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import template.domain.member.constant.MemberType;
import template.external.oauth.kakao.client.KakaoUserInfoClient;
import template.external.oauth.kakao.dto.KaKaoUserInfoResponseDto;
import template.external.oauth.model.OAuthAttributes;
import template.external.oauth.service.SocialLoginApiService;
import template.global.jwt.constant.GrantType;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class KaKaoLoginApiServiceImpl implements SocialLoginApiService {

    private final KakaoUserInfoClient kakaoUserInfoClient;
    private final String CONTENT_TYPE = "application/x-www-form-urlencoded;charset=utf-8";

    @Override
    public OAuthAttributes getUserInfo(String accessToken) {
        KaKaoUserInfoResponseDto kaKaoUserInfo = kakaoUserInfoClient.getKakaoUserInfo(CONTENT_TYPE,
                GrantType.BEARER.getType() + " " + accessToken);
        KaKaoUserInfoResponseDto.KaKaoAccount kaKaoAccount = kaKaoUserInfo.getKaKaoAccount();
        String email = kaKaoAccount.getEmail();
        log.info("Email = {} " + email);
        return OAuthAttributes.builder()
                .email(StringUtils.hasText(email) ? email : kaKaoUserInfo.getId())
                .name(kaKaoAccount.getProfile().getNickname())
                .profile(kaKaoAccount.getProfile().getThumbnailImageUrl())
                .memberType(MemberType.KAKAO)
                .build();
    }

}
