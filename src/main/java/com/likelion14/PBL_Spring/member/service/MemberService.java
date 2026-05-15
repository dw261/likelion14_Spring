package com.likelion14.PBL_Spring.member.service;

import com.likelion14.PBL_Spring.member.domain.role.*;
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

    public Role createLion (LionCreateRequest request){
        Lion lion = new Lion(request.getName(), request.getMajor(), request.getGeneration(),
                request.getPart(), request.getStudentId());

        if( searchByName(request.getName()) != null ){
            return null;
        }
        repository.save(lion);
        return lion;
    }

    public Role createStaff (StaffCreateRequest request){
        Staff staff = new Staff(request.getName(), request.getMajor(), request.getGeneration(),
                request.getPart(), request.getPosition());

        if( searchByName(request.getName()) != null ){
            return null;
        }
        repository.save(staff);
        return staff;
    }

    public Role updateLion (String name, LionUpdateRequest request){
        if (searchByName(name) == null) {
            return null;
        }

        Lion updated = new Lion(name, request.getMajor(), request.getGeneration(),
                request.getPart(), request.getStudentId());
        repository.updateByName(name, updated);
        return updated;
    }

    public Role updateStaff (String name, StaffUpdateRequest request){
        if (searchByName(name) == null) {
            return null;
        }

        Staff updated = new Staff(name, request.getMajor(), request.getGeneration(),
                request.getPart(), request.getPosition());
        repository.updateByName(name, updated);
        return updated;
    }

    public boolean deleteMember(String name) {
        return repository.deleteMember(name);
    }
}
