package template.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import template.domain.member.entity.Member;

import java.util.Optional;

public interface MemberRespository extends JpaRepository<Member, Long> {

    // 쿼리메서드 기능
    Optional<Member> findByEmail(String email);
}
