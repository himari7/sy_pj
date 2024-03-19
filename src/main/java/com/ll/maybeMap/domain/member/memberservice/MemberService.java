package com.ll.maybeMap.domain.member.memberservice;

//import com.ll.maybeMap.domain.member.Dto.MemberCreateDto;
//import com.ll.maybeMap.domain.member.entity.Member;
//import com.ll.maybeMap.domain.member.memberrepository.MemberRepository;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;

import com.ll.maybeMap.domain.member.Dto.MemberCreateDto;
import com.ll.maybeMap.domain.member.entity.Member;
import com.ll.maybeMap.domain.member.memberrepository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Long createMember(MemberCreateDto memberCreateDto) {
        Member member = Member.builder()
                .username(memberCreateDto.getUsername())
                .email(memberCreateDto.getEmail())
                .password(memberCreateDto.getPassword())
                .build();

        memberRepository.save(member);
        return member.getId();
    }
}