package com.example.server_register.service.impl;

import com.example.server_register.dto.MemberDto;
import com.example.server_register.model.Member;
import com.example.server_register.repository.MemberRepo;
import com.example.server_register.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepo memberRepo;

    @Override
    public Member checkLogin(Member member) {
        return memberRepo.checkAccount(member);
    }
}
