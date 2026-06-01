package com.likelion14.PBL_Spring.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AssignmentUpdateRequest {
    private String title;
    private String description;

    public AssignmentUpdateRequest(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
