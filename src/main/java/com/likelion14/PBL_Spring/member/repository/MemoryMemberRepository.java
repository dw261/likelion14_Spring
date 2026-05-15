package com.likelion14.PBL_Spring.member.repository;

import java.util.ArrayList;
import java.util.List;

import com.likelion14.PBL_Spring.member.domain.role.Role;
import com.likelion14.PBL_Spring.member.repository.MemberRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MemoryMemberRepository implements MemberRepository {
    private List<Role> members = new ArrayList<>();

    @Override
    public void save(Role member){
        members.add(member);
    }

    @Override
    public Role findByName(String name){
        for (Role member : members){
            if (member.getName().equals(name)){
                return member;
            }
        }
        return null;
    }

    @Override
    public List<Role> findAll(){ return members; }

    @Override
    public boolean existsByName(String name){
        for (Role member : members){
            if (member.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateByName(String name, Role member){
        for (Role role : members){
            if (role.getName().equals(name)){
                members.remove(role);
                members.add(member);
            }
        }
    }

    @Override
    public boolean deleteMember(String name){
        for (Role member : members){
            if (member.getName().equals(name)) {
                members.remove(member);
                return true;
            }
        }
        return false;
    }
}
