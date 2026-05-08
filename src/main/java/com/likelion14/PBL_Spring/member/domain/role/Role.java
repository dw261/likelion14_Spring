package com.likelion14.PBL_Spring.member.domain.role;

import com.likelion14.PBL_Spring.member.domain.policy.SubmissionPolicy;

public abstract class Role {
    public abstract String getInfo();
    public abstract String roleName();
    public abstract SubmissionPolicy SubmissionPolicy();
    private String name;
    private String major;
    private int generation;
    private String part;

    protected Role(String name, String major, int generation, String part){
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

    //wrapper 메서드 역할을 해서 기존 main 코드와 호환성 유지
    //Role의 canSubmitAssignment()가 내부적으로 SubmissionPolicy().canSubmit() 호출
    public final boolean canSubmitAssignment() {
        return SubmissionPolicy().canSubmit();
    }

    public final String getName() { return name; }
    public final String getMajor() { return major; }
    public final int getGeneration() { return generation; }
    public final String getPart() { return part; }
    public abstract String getExtra();
}
