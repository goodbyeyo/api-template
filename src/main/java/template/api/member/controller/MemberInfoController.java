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

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberInfoController {

    private final MemberInfoService memberInfoService;
    private final TokenManager tokenManager;

    @GetMapping("/info")
    public ResponseEntity<MemberInfoResponseDto> getMemberInfo(@RequestHeader("Authorization")
                                                                   String authorizationHeader){
        String accessToekn = authorizationHeader.split(" ")[1];
        Claims tokenClaims = tokenManager.getTokenClaims(accessToekn);
        Long memberId = Long.valueOf((Integer) tokenClaims.get("memberId"));
        MemberInfoResponseDto memberInfoResponseDto = memberInfoService.getMemberInfo(memberId);
        return ResponseEntity.ok(memberInfoResponseDto);

    }

}
