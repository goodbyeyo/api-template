package template.external.oauth.kakao.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import template.external.oauth.kakao.client.KaKaoUserInfoClient;
import template.external.oauth.model.OAuthAttributes;
import template.external.oauth.service.SocialLoginApiService;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class KaKaoLoginApiServiceImpl implements SocialLoginApiService {

    private final KaKaoUserInfoClient kaKaoUserInfoClient;
    private final String CONTENT_TYPE = "application/x-www-form-urlencoded;charset=utf-8";

    @Override
    public OAuthAttributes getUserInfo(String accessToken) {
        return null;
    }
}
