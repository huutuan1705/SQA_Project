package com.example.server_register.controller;

import com.example.server_register.commons.RegisterRespone;
import com.example.server_register.commons.exception.ErrorMessageConstant;
//import com.example.server_register.config.security.JwtService;
import com.example.server_register.model.AuthRequest;
import com.example.server_register.model.Member;
import com.example.server_register.service.MemberService;
import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.util.ObjectUtils;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/members")
@RequiredArgsConstructor
@CrossOrigin
public class MemberController {

    private final MemberService memberService;
//    private final JwtService jwtService;
//    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public Member login(@RequestBody Member member){
        return memberService.checkLogin(member);
    }

//    @PostMapping("/authenticate")
//    public ResponseEntity<?> authenticate(@RequestBody AuthRequest authRequest){
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
//        if ( authentication.isAuthenticated()){
//            return ResponseEntity.ok(jwtService.generateToken(authRequest.getUsername()));
//        }
//        throw new UsernameNotFoundException("not found");
//    }

//    @PostMapping("/authenticate")
//    public ResponseEntity<?> auth(@RequestBody Member member){
//
//        String existingToken = jwtService.getTokenForMember(member.getUsername());
//        if(existingToken != null) {
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("Authorization", "Bearer " + existingToken);
//            return ResponseEntity.ok().headers(headers).body(memberService.checkLogin(member));
//        }
//
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(member.getUsername(), member.getPassword()));
//        if ( authentication.isAuthenticated()){
//            String token = jwtService.generateToken(member.getUsername());
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("Authorization", "Bearer " + token);
//            return ResponseEntity.ok()
//                                .headers(headers)
//                                .body(RegisterRespone.build(memberService.checkLogin(member)));
//        }
//        return new ResponseEntity(RegisterRespone.build(ErrorMessageConstant.NOT_FOUND), HttpStatus.OK);
//    }
}
