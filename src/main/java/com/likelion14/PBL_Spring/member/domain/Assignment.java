package com.likelion14.PBL_Spring.member.domain;

import com.likelion14.PBL_Spring.member.domain.Member;
import jakarta.persistence.*;

@Entity
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    // 기본 생성자
    protected Assignment() {
    }

    // 생성용 생성자
    public Assignment(String title, String description, Member member) {
        this.title = title;
        this.description = description;
        this.member = member;
    }

    // 수정용 메서드
    public void updateInfo(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Getter 메서드
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public Member getMember() { return member; }
}