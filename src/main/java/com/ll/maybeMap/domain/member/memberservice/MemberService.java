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

import com.ll.maybeMap.domain.member.entity.Member;
import com.ll.maybeMap.domain.member.memberrepository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MemberService(MemberRepository memberRepository,PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public Member create(String username, String email, String password) {
        Member user = new Member();
        user.setUsername(username);
        user.setEmail(email);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(password));
        return memberRepository.save(user);
    }
}