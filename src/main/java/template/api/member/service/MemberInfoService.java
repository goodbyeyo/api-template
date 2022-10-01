package template.api.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import template.api.member.dto.MemberInfoResponseDto;
import template.domain.member.entity.Member;
import template.domain.member.repository.MemberRespository;
import template.domain.member.service.MemberService;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberInfoService {

    private final MemberService memberService;
    public MemberInfoResponseDto getMemberInfo(Long memberId) {
        Member member = memberService.findMemberByMemberId(memberId);
        return MemberInfoResponseDto.of(member);

    }
}
