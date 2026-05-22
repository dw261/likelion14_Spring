package com.likelion14.PBL_Spring.member.domain;

import com.likelion14.PBL_Spring.member.dto.MemberResponse;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String major;
    private String part;
    private int generation;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    private String studentId;
    private String position;

    @Builder
    public Member(String name, String major, int generation, String part,
                  RoleType roleType, String studentId, String position) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.roleType = roleType;
        this.studentId = studentId;
        this.position = position;
    }

    // 수정용 메서드
    public void updateInfo(String major, int generation, String part){
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

    public void updateStudentId(String studentId){
        this.studentId = studentId;
    }

    public void updatePosition(String position){
        this.position = position;
    }
}
