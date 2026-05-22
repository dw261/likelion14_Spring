package com.likelion14.PBL_Spring.member.dto;

import com.likelion14.PBL_Spring.member.domain.Member;

public class MemberResponse {
    private Long id;
    private String name;
    private String major;
    private int generation;
    private String part;
    private String roleName;
    private String studentId;
    private String position;

    public static MemberResponse from(Member member) {
        MemberResponse response = new MemberResponse();
        response.id = member.getId();
        response.name = member.getName();
        response.major = member.getMajor();
        response.generation = member.getGeneration();
        response.part = member.getPart();
        response.roleName = String.valueOf(member.getRoleType());
        response.studentId = member.getStudentId();
        response.position = member.getPosition();
        return response;
    }

    // Getter 지정
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }
    public String getRoleName() { return roleName; }
    public String getStudentId() { return studentId; }
    public String getPosition() { return position; }

}
