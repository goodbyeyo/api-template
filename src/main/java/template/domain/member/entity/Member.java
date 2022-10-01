package template.domain.member.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import template.domain.common.BaseEntity;
import template.domain.member.constant.MemberType;
import template.domain.member.constant.Role;
import template.global.jwt.dto.JwtTokenDto;

import javax.persistence.*;
import java.time.LocalDateTime;

import static template.global.util.DateTimeUtils.convertToLocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Enumerated(EnumType.STRING)    // ORDINAL :  순서
    @Column(nullable = false, length = 10)
    private MemberType memberType;

    @Column(unique = true, length = 50, nullable = false)
    private String email;

    @Column(length = 200)
    private String password;

    @Column(nullable = false, length = 20)
    private String memberName;

    @Column(length = 200)
    private String profile;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Role role;

    @Column(length = 250)
    private String refreshToken;

    private LocalDateTime tokenExpirationTime;

    @Builder
    public Member(MemberType memberType,
                  String email,
                  String password,
                  String memberName,
                  String profile,
                  Role role) {
        this.memberType = memberType;
        this.email = email;
        this.password = password;
        this.memberName = memberName;
        this.profile = profile;
        this.role = role;
    }

    public void updateRefreshToken(JwtTokenDto jwtTokenDto) {
        this.refreshToken = jwtTokenDto.getRefreshToken();
        // date -> localDateTime
        this.tokenExpirationTime = convertToLocalDateTime(jwtTokenDto.getRefreshTokenExpireTime());
    }

    public void expiredRefreshToken(LocalDateTime now) {
        this.tokenExpirationTime = now;
    }
}
