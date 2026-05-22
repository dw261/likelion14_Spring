package com.likelion14.PBL_Spring.member.repository;

import com.likelion14.PBL_Spring.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByName(String name);
    boolean existsByName(String name);

    @Query("SELECT n FROM Member n where n.name = :name")
    Optional<Member> findByNameUsingJpql(String name);
}
