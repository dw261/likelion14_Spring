package com.likelion14.PBL_Spring.member.controller;

import com.likelion14.PBL_Spring.member.domain.Assignment;
import com.likelion14.PBL_Spring.member.dto.AssignmentCreateRequest;
import com.likelion14.PBL_Spring.member.dto.AssignmentResponse;
import com.likelion14.PBL_Spring.member.dto.AssignmentUpdateRequest;
import com.likelion14.PBL_Spring.member.service.AssignmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssignmentController {
    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService){
        this.assignmentService = assignmentService;
    }

    // GET /assignments/search?keyword={검색어} - JPQL 키워드 검색
    @GetMapping("/assignments/search")
    public ResponseEntity<AssignmentResponse> searchAssignments(@RequestParam("keyword") String keyword) {
        Assignment assignments = assignmentService.searchByTitle(keyword);
        if(assignments == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(AssignmentResponse.from(assignments));
    }

    // Post /members/{memberId}/assignments - 과제 등록
    @PostMapping("/members/{memberId}/assignments")
    public ResponseEntity<AssignmentResponse> create(@PathVariable Long memberId,
                                                     @RequestBody AssignmentCreateRequest request){
        Assignment assignment = assignmentService.create(memberId, request);
        if (assignment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(AssignmentResponse.from(assignment));
    }

    // GET /members/{memberId}/assignments - 멤버별 과제 조회
    @GetMapping("/members/{memberId}/assignments")
    public ResponseEntity<List<AssignmentResponse>> findByMemberId(@PathVariable Long memberId){
        List<AssignmentResponse> responses = assignmentService.findByMemberId(memberId).stream()
                .map(AssignmentResponse::from)
                .toList();
        return ResponseEntity.ok(responses);
    }

    // GET /assignments/{id} - 단건 조회
    @GetMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse>findById(@PathVariable Long id){
        Assignment assignment = assignmentService.findById(id);
        if (assignment == null) {
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(AssignmentResponse.from(assignment));
    }

    // PUT /assignments/{id} - 과제 수정
    @PutMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> update(@PathVariable Long id,
                                                     @RequestBody AssignmentUpdateRequest request){
        Assignment updated = assignmentService.update(id, request);
        if (updated == null) {
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(AssignmentResponse.from(updated));
    }

    // DELETE /assignments/{id} - 과제 삭제
    @DeleteMapping("/assignments/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        boolean success = assignmentService.delete(id);
        if (!success) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}