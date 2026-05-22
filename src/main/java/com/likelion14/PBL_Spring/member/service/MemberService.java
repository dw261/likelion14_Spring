package com.likelion14.PBL_Spring.member.service;

import com.likelion14.PBL_Spring.member.domain.Member;
import com.likelion14.PBL_Spring.member.domain.RoleType;
import com.likelion14.PBL_Spring.member.dto.*;
import com.likelion14.PBL_Spring.member.repository.MemberRepository;
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

    public Member searchByName(String name){
        return repository.findByName(name).orElse(null);
    }

    public List<Member> getAllMembers() {
        return repository.findAll();
    }

    public boolean isEmpty() { return repository.findAll().isEmpty(); }

    public Member createLion (LionCreateRequest request){
        if(repository.existsByName(request.getName())) {
            return null;
        }
        Member member = new Member(request.getName(), request.getMajor(), request.getGeneration(),
                request.getPart(), RoleType.LION, request.getStudentId(), null );

        return repository.save(member);
    }

    public Member createStaff (StaffCreateRequest request){
        if(repository.existsByName(request.getName())) {
            return null;
        }
        Member member = new Member(request.getName(), request.getMajor(), request.getGeneration(),
                request.getPart(), RoleType.STAFF, null, request.getPosition());

        return repository.save(member);
    }

    public Member updateLion(Long id, LionUpdateRequest request) {
        Member member = repository.findById(id).orElse(null);
        if(member == null) {
            return null;
        }
        member.updateInfo(request.getMajor(), request.getGeneration(), request.getPart());
        member.updateStudentId(request.getStudentId());
        return repository.save(member);
    }

    public Member updateStaff (Long id, StaffUpdateRequest request) {
        Member member = repository.findById(id).orElse(null);
        if(member == null) {
            return null;
        }
        member.updateInfo(request.getMajor(), request.getGeneration(), request.getPart());
        member.updateStudentId(request.getPosition());
        return repository.save(member);
    }

    // ID로 조회
    public Member findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public boolean deleteMember(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
