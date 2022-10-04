package template.api.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import template.domain.member.constant.Role;
import template.domain.member.entity.Member;

@Getter
@Builder
public class MemberInfoResponseDto {

    @Schema(description = "회원 아이디", example = "1", required = true)
    private Long memberId;

    @Schema(description = "이메일", example = "sample@gmail.com", required = true)
    private String email;

    @Schema(description = "회원 이름", example = "홍길동", required = true)
    private String memberName;

    @Schema(description = "프로필 이미지 경로", example = "http://k.kakaocdn.net/img_110x110.jpg", required = false)
    private String profile;

    @Schema(description = "회원 역할", example = "USER", required = true)
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
