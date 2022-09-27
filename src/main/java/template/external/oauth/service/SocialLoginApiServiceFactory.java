package template.external.oauth.service;

import org.springframework.stereotype.Service;
import template.domain.member.constant.MemberType;

import java.util.Map;

@Service
public class SocialLoginApiServiceFactory {

    private static Map<String, SocialLoginApiService> socialLoginApiServices;

    public SocialLoginApiServiceFactory(Map<String, SocialLoginApiService> socialLoginApiServices) {
        this.socialLoginApiServices = socialLoginApiServices;
    }

    public static SocialLoginApiService getSocialLoginApiServices(MemberType memberType) {
        String socialLoginApiServiceBeanName = "";

        if (MemberType.KAKAO.equals(memberType)) {
            socialLoginApiServiceBeanName = "kaKaoLoginApiServiceImpl";
        }
        return socialLoginApiServices.get(socialLoginApiServiceBeanName);
    }
}
