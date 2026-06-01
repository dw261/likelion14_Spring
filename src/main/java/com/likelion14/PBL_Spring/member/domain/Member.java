package com.likelion14.PBL_Spring.member.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    private String name;
    private String major;
    private String part;
    private int generation;

    private String studentId;
    private String position;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Assignment> assignments = new ArrayList<>();

    @Builder
    public Member(String name, String major, int generation, String part,
                  RoleType roleType, String studentId, String position) {
        this.roleType = roleType;
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
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
