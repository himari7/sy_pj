package com.ll.maybeMap.domain.member.memberrepository;

import com.ll.maybeMap.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}