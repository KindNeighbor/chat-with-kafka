package api.chat.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.chat.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
