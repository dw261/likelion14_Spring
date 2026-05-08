package com.likelion14.PBL_Spring.member.domain.policy;

public class StaffSubmissionPolicy implements SubmissionPolicy{

    @Override
    public Boolean canSubmit(){
        return false;
    }
}
