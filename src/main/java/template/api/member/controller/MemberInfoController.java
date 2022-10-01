package template.api.member.controller;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import template.api.member.dto.MemberInfoResponseDto;
import template.api.member.service.MemberInfoService;
import template.global.jwt.service.TokenManager;
import template.global.resolver.memberinfo.MemberInfo;
import template.global.resolver.memberinfo.MemberInfoDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberInfoController {

    private final MemberInfoService memberInfoService;
    private final TokenManager tokenManager;

    @GetMapping("/info")
    public ResponseEntity<MemberInfoResponseDto> getMemberInfo(
//            @RequestHeader("Authorization") String authorizationHeader){
            @MemberInfo MemberInfoDto memberInfoDto){
//        String accessToken  = authorizationHeader.split(" ")[1];
//        Claims tokenClaims = tokenManager.getTokenClaims(accessToken);
//        Long memberId = Long.valueOf((Integer) tokenClaims.get("memberId"));
        Long memberId = memberInfoDto.getMemberId();
        MemberInfoResponseDto memberInfoResponseDto = memberInfoService.getMemberInfo(memberId);
        return ResponseEntity.ok(memberInfoResponseDto);

    }

}
