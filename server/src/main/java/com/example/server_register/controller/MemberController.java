package com.example.server_register.controller;

import com.example.server_register.model.Member;
import com.example.server_register.repository.MemberRepo;
import com.example.server_register.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public Member login(@RequestBody Member member){
        return memberService.checkLogin(member);
    }
}
