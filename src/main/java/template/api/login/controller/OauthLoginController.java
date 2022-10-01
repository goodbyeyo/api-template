package template.api.login.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import template.api.login.dto.OauthLoginDto;
import template.api.login.service.OauthLoginService;
import template.api.login.validator.OauthValidator;
import template.domain.member.constant.MemberType;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/oauth")
public class OauthLoginController {
    private final OauthValidator oauthValidator;
    private final OauthLoginService oauthLoginService;

    @PostMapping("/login")
    public ResponseEntity<OauthLoginDto.Response> oauthLogin(@RequestBody OauthLoginDto.Request request,
                                                             HttpServletRequest httpServletRequest) {
        String authorizationHeader = httpServletRequest.getHeader("Authorization");
        oauthValidator.validateAuthorization(authorizationHeader);
        oauthValidator.validateMemberType(authorizationHeader);
        String accessToken = authorizationHeader.split(" ")[1];
        OauthLoginDto.Response jwtTokenResponseDto =
                oauthLoginService.oauthLogin(accessToken, MemberType.from(request.getMemberType()));
        return ResponseEntity.ok(jwtTokenResponseDto);
    }

}
