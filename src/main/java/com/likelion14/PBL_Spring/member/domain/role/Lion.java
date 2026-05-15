package com.likelion14.PBL_Spring.member.domain.role;

import com.likelion14.PBL_Spring.member.domain.policy.*;
import com.likelion14.PBL_Spring.member.domain.role.Role;

public class Lion extends Role {
    private String studentId;

    @Override
    public String getInfo(){
        return "이름: "+ getName() + " | 전공: " + getMajor() +
                " | 기수 : " + getGeneration() + " | 파트: " + getPart() +
                "\n학번: " + getExtra();
    }

    @Override
    public String roleName(){ return "아기사자"; }

    @Override
    public SubmissionPolicy SubmissionPolicy() {
        return new LionSubmissionPolicy();
    }

    @Override
    public String getExtra() {
        return studentId;
    }

    public Lion(String name, String major, int generation, String part, String studentId){
        super(name, major, generation, part);
        this.studentId = studentId;
    }


}
