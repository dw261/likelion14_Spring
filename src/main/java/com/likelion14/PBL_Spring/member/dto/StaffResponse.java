package com.likelion14.PBL_Spring.member.dto;

import com.likelion14.PBL_Spring.member.domain.role.Staff;

public class StaffResponse {
    private String roleName;
    private String name;
    private String major;
    private int generation;
    private String part;
    private String position;

    public String getRoleName() { return roleName; }
    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }
    public String getPosition() { return position; }

    public static StaffResponse from(Staff staff) {
        StaffResponse response = new StaffResponse();
        response.roleName = staff.roleName();
        response.name = staff.getName();
        response.major = staff.getMajor();
        response.generation = staff.getGeneration();
        response.part = staff.getPart();
        response.position = staff.getExtra();
        return response;
    }
}
