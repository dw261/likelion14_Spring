package com.likelion14.PBL_Spring.member.domain.role;
import com.likelion14.PBL_Spring.member.domain.policy.*;

public class Staff extends Role{
    @Override
    public String getInfo(){
        return "이름: "+ getName() + " | 전공: " + getMajor() +
                " | 기수 : " + getGeneration() + " | 파트: " + getPart() +
                "\n직책: " + position;
    }

    @Override
    public String roleName(){ return "운영진"; }

    @Override
    public SubmissionPolicy SubmissionPolicy() {
        return new StaffSubmissionPolicy();
    }
    private String position;

    @Override
    public String getExtra(){
        return position;
    }

    public Staff(String name, String major, int generation, String part, String position){
        super(name, major, generation, part);
        this.position = position;
    }
}
