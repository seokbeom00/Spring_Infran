package com.example.spring_introduction;

import com.example.spring_introduction.repository.*;
import com.example.spring_introduction.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
//    private EntityManager em;
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }
//
//    @Bean
//    public MemberRepository memberRepository(){
////        return new JpaMemberRepository(em);
////        return new JdbcTemplateMemberRepository(dataSource);
////        return new JdbcMemberRepository(dataSource);
////        return new MemoryMemberRepository();
//    }
}
