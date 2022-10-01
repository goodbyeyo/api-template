package template.api.member.dto;

import lombok.Builder;
import lombok.Getter;
import template.domain.member.constant.Role;
import template.domain.member.entity.Member;

@Getter
@Builder
public class MemberInfoResponseDto {

    private Long memberId;
    private String email;
    private String memberName;
    private String profile;
    private Role role;

    public static MemberInfoResponseDto of(Member member) {
        return MemberInfoResponseDto.builder()
                .memberId(member.getMemberId())
                .email(member.getEmail())
                .memberName(member.getMemberName())
                .profile(member.getProfile())
                .role(member.getRole())
                .build();
    }
}
