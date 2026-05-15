package com.likelion14.PBL_Spring.member.dto;

public class LionCreateRequest {
    String name;
    String major;
    int generation;
    String part;
    String studentId;

    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }
    public String getStudentId() { return studentId; }
}
