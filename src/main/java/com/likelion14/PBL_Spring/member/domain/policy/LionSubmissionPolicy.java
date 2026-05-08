package com.likelion14.PBL_Spring.member.domain.policy;

public class LionSubmissionPolicy implements SubmissionPolicy{

    @Override
    public Boolean canSubmit(){
        return true;
    }
}
