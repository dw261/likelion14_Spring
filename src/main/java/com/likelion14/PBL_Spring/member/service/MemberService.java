package com.likelion14.PBL_Spring.member.service;

import com.likelion14.PBL_Spring.member.domain.role.Role;
import com.likelion14.PBL_Spring.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    //인터페이스에 의존 (구현체에 의존하지 않음)
    private final MemberRepository repository;

    // 생성자를 통해 의존성 주입
    //@Autowired // 주석 처리로 생성자가 1개일 때는 @Autowired를 생략해도 동작하는지 확인
    public MemberService(MemberRepository repository){
        this.repository = repository; }

    public boolean register(Role member){
        if(repository.existsByName(member.getName())){
            return false;
        }
        repository.save(member);
        return true;
    }

    public Role searchByName(String name){ return repository.findByName(name); }

    public List<Role> getAllMembers() { return repository.findAll(); }

    public boolean isEmpty() { return repository.findAll().isEmpty(); }
}
