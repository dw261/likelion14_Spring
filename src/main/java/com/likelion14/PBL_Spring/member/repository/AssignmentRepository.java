package com.likelion14.PBL_Spring.member.repository;

import com.likelion14.PBL_Spring.member.domain.Assignment;
import com.likelion14.PBL_Spring.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByMemberId(Long memberId);

    @Query("SELECT n FROM Assignment n where n.title LIKE %:keyword%")
    Optional<Assignment> findByTitleUsingJpql(String keyword);
}
