package com.ll.maybeMap.domain.member.membercontroller;

import com.ll.maybeMap.domain.member.Dto.MemberCreateDto;
import com.ll.maybeMap.domain.member.memberservice.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberCreateDto());
        return "domain/member/members";
    }

    @PostMapping("/members/new")
    public String create(MemberCreateDto form) {
        memberService.createMember(form);
        return "redirect:/";
    }
}