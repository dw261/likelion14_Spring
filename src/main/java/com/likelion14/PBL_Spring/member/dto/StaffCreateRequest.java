package com.likelion14.PBL_Spring.member.dto;

public class StaffCreateRequest {
    String name;
    String major;
    int generation;
    String part;
    String position;

    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }
    public String getPosition() { return position; }
}
