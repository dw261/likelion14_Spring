package com.likelion14.PBL_Spring.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AssignmentCreateRequest {
    private String title;
    private String description;

    // 생성자
    public AssignmentCreateRequest(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
