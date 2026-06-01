package com.likelion14.PBL_Spring.member.service;

import com.likelion14.PBL_Spring.member.domain.Assignment;
import com.likelion14.PBL_Spring.member.domain.Member;
import com.likelion14.PBL_Spring.member.dto.AssignmentCreateRequest;
import com.likelion14.PBL_Spring.member.dto.AssignmentUpdateRequest;
import com.likelion14.PBL_Spring.member.repository.AssignmentRepository;
import com.likelion14.PBL_Spring.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;
    private final MemberRepository memberRepository;

    public AssignmentService(AssignmentRepository assignmentRepository, MemberRepository memberRepository) {
        this.assignmentRepository = assignmentRepository;
        this.memberRepository = memberRepository;
    }

    public Assignment searchByTitle(String keyword){
        return assignmentRepository.findByTitleUsingJpql(keyword).orElse(null);
    }

    //과제 등록
    @Transactional
    public Assignment create(Long memberId, AssignmentCreateRequest request) {
        Member member = memberRepository.findById(memberId).orElse(null);
        if (member == null) {
            return null;
        }
        Assignment assignment = new Assignment(request.getTitle(), request.getDescription(), member);
        return assignmentRepository.save(assignment);
    }

    // 멤버별 조회
    public List<Assignment> findByMemberId(Long memberId) {
        return assignmentRepository.findByMemberId(memberId);
    }

    //단건 조회
    public Assignment findById(Long id) {
        return assignmentRepository.findById(id).orElse(null);
    }

    //수정
    @Transactional
    public Assignment update(Long id, AssignmentUpdateRequest request) {
        Assignment assignment = assignmentRepository.findById(id).orElse(null);
        if (assignment == null) {
            return null;
        }
        assignment.updateInfo(request.getTitle(), request.getDescription());
        return  assignmentRepository.save(assignment);
    }

    // 삭제
    @Transactional
    public boolean delete(Long id) {
        if (!assignmentRepository.existsById(id)) {
            return false;
        }
        assignmentRepository.deleteById(id);
        return true;
    }
}
