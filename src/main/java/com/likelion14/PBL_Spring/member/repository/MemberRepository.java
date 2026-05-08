package com.likelion14.PBL_Spring.member.repository;

import com.likelion14.PBL_Spring.member.domain.role.Role;

import java.util.List;

public interface MemberRepository {
    void save(Role member);
    Role findByName(String name);
    List<Role> findAll();
    boolean existsByName(String name);
}
