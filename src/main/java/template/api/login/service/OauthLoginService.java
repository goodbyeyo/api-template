package template.api.login.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import template.api.login.dto.OauthLoginDto;
import template.domain.member.constant.MemberType;
import template.domain.member.constant.Role;
import template.domain.member.entity.Member;
import template.domain.member.service.MemberService;
import template.external.oauth.service.SocialLoginApiServiceFactory;
import template.external.oauth.model.OAuthAttributes;
import template.external.oauth.service.SocialLoginApiService;
import template.global.jwt.dto.JwtTokenDto;
import template.global.jwt.service.TokenManager;

import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class OauthLoginService {

    private final MemberService memberService;
    private final TokenManager tokenManager;

    public OauthLoginDto.Response oauthLogin(String accessToken, MemberType memberType) {
        SocialLoginApiService socialLoginApiService = SocialLoginApiServiceFactory.getSocialLoginApiServices(memberType);
        OAuthAttributes userInfo = socialLoginApiService.getUserInfo(accessToken);
        log.info("userInfo = {}", userInfo);

        JwtTokenDto jwtTokenDto;
        Optional<Member> optionalMember = memberService.findMemberByEmail(userInfo.getEmail());
        if (optionalMember.isEmpty()) { // 신규 회원인 경우
            Member oauthMember = userInfo.toMemberEntity(memberType, Role.ADMIN);
            oauthMember = memberService.registerMember(oauthMember);

            // token create
            jwtTokenDto = tokenManager.createJwtTokenDto(oauthMember.getMemberId(), oauthMember.getRole());
            oauthMember.updateRefreshToken(jwtTokenDto);

        }else{ // 기존 회원인 경우
            Member oauthMember = optionalMember.get();

            // token create
            jwtTokenDto = tokenManager.createJwtTokenDto(oauthMember.getMemberId(), oauthMember.getRole());
            oauthMember.updateRefreshToken(jwtTokenDto);
        }

        return OauthLoginDto.Response.of(jwtTokenDto);
    }

}
