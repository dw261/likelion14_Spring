package com.likelion14.PBL_Spring.member.dto;

import com.likelion14.PBL_Spring.member.domain.Assignment;
import lombok.Getter;

@Getter
public class AssignmentResponse {
    private final Long id;
    private final String title;
    private final String description;
    private final Long memberId;
    private final String memberName;

    // 내부 생성자
    private AssignmentResponse(Long id, String title, String description, Long memberId, String memberName) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.memberId = memberId;
        this.memberName = memberName;
    }

    // 엔티티를 DTO로 변환
    public static AssignmentResponse from(Assignment assignment){
        return new AssignmentResponse(
                assignment.getId(),
                assignment.getTitle(),
                assignment.getDescription(),
                assignment.getMember() != null ? assignment.getMember().getId() : null,
                assignment.getMember() != null ? assignment.getMember().getName() : null
        );
    }
}
