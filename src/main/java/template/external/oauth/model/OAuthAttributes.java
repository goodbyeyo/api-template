package template.external.oauth.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import template.domain.member.constant.MemberType;
import template.domain.member.constant.Role;
import template.domain.member.entity.Member;

@Getter
@Builder
@ToString
public class OAuthAttributes {
    private String name;
    private String email;
    private String profile;
    private MemberType memberType;

    public Member toMemberEntity(MemberType memberType, Role role) {
        return Member.builder()
                .memberName(name)
                .email(email)
                .profile(profile)
                .role(role)
                .build();
    }

}
