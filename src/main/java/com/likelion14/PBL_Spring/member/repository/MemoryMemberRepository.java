package com.likelion14.PBL_Spring.member.repository;

import java.util.ArrayList;
import java.util.List;

import com.likelion14.PBL_Spring.member.domain.role.Role;
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
}
