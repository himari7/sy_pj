package com.ll.maybeMap.domain.member.membercontroller;

import com.ll.maybeMap.domain.member.Dto.MemberCreateDto;
import com.ll.maybeMap.domain.member.memberservice.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/posts")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signup")
    public String signup(MemberCreateDto memberCreateDto) {
        return "domain/member/signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid MemberCreateDto memberCreateDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "domain/member/signup";
        }

        if (!memberCreateDto.getPassword1().equals(memberCreateDto.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "domain/member/signup";
        }

        memberService.create(memberCreateDto.getUsername(),
                memberCreateDto.getEmail(), memberCreateDto.getPassword1());

        return "redirect:/posts/";
    }

    @GetMapping("/login")
    public String login() {
        return "domain/member/longin";
    }
}