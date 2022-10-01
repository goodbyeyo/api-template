package template.global.resolver.memberinfo;

import lombok.Builder;
import lombok.Getter;
import template.domain.member.constant.Role;

@Getter
@Builder
public class MemberInfoDto {

    private Long memberId;
    private Role role;
}
