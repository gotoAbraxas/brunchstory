package com.example.brunchStory.member.service;


import com.example.brunchStory.config.auth.AuthService;
import com.example.brunchStory.config.exception.LoginFailException;
import com.example.brunchStory.member.domain.entity.Member;
import com.example.brunchStory.member.domain.request.LoginRequest;
import com.example.brunchStory.member.domain.response.LoginResponse;
import com.example.brunchStory.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final AuthService authService;


    public LoginResponse login(LoginRequest request) {
        Optional<Member> byUserIdAndPassword =
                memberRepository
                        .findByUserIdAndPassword(request.userId(), request.password());
        Member member = byUserIdAndPassword
                .orElseThrow(() -> new LoginFailException("존재하지 않는 유저입니다"));

        String token = authService.makeToken(member);
        return new LoginResponse(member.getId(), member.getName(), member.getEmail(), member.getRole(), token);
    }

}
