package com.example.server_register.controller;

import com.example.server_register.model.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/members")
public class MemberController {

    @GetMapping("/login")
    public String login(@RequestBody Member member){
        return null;
    }
}
