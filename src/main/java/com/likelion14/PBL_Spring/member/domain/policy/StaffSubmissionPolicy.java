package com.likelion14.PBL_Spring.member.domain.policy;

import com.likelion14.PBL_Spring.member.domain.policy.SubmissionPolicy;

public class StaffSubmissionPolicy implements SubmissionPolicy {

    @Override
    public Boolean canSubmit(){
        return false;
    }
}
