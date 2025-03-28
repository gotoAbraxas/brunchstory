package com.example.bookBook.member.controller;


import com.example.bookBook.member.domain.request.LoginRequest;
import com.example.bookBook.member.domain.response.LoginResponse;
import com.example.bookBook.member.service.MemberService;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.access.prepost.PreAuthorize;

import com.example.bookBook.member.domain.request.SignupRequest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {
    private final MemberService memberService;


    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return memberService.login(loginRequest);
    }

//
//    @GetMapping("test1")
////    @PreAuthorize("hasRole('ROLE_AUTHOR')")
//    public void writerTest(){
//        System.out.println("작가네요");
//    }
//
//
//    @GetMapping("test2")
//    @PreAuthorize("hasAnyRole('ROLE_AUTHOR', 'ROLE_MEMBER')")
//    public void twoRoleTest(){
//        System.out.println("당신은 두개의 역할을 가지고 있군요");
//    }
//
//    @GetMapping("test3")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public void adminTest() {
//        System.out.println("관리자시군요");
//    }
    @PostMapping("/signup")
//    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody SignupRequest signupRequest){
        memberService.insert(signupRequest);

    }
}
