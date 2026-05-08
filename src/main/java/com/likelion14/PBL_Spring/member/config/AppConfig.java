package com.likelion14.PBL_Spring.member.config;

import com.likelion14.PBL_Spring.member.repository.*;
import com.likelion14.PBL_Spring.member.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration //Step2에서 자동 주입으로 전활할 때 주석 처리 -> 자동 주입만으로 동작하는지 확인
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
}
