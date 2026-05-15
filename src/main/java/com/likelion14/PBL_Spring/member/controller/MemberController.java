package com.likelion14.PBL_Spring.member.controller;

import com.likelion14.PBL_Spring.member.domain.role.*;
import com.likelion14.PBL_Spring.member.dto.*;
import com.likelion14.PBL_Spring.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    //POST /members/lions - Lion 등록
    @Operation(summary = "Lion(아기사자) 등록")
    @PostMapping("/lions")
    public ResponseEntity<LionResponse> createLion(@RequestBody LionCreateRequest request){
        Role lion = memberService.createLion(request);
        if(lion == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(LionResponse.from((Lion) lion));
    }

    //POST /members/staffs - Staff 등록
    @Operation(summary = "Staff(운영진) 등록")
    @PostMapping("/staffs")
    public ResponseEntity<StaffResponse> createStaff(@RequestBody StaffCreateRequest request){
        Role staff = memberService.createStaff(request);
        if(staff == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(StaffResponse.from((Staff) staff));
    }

    // Get /members/{name} - 단건 조회
    @Operation(summary = "이름으로 단일 멤버 조회")
    @GetMapping("/{name}")
    public ResponseEntity<?> getMember(@PathVariable String name){
        Role member = memberService.searchByName(name);
        if (member == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toResponse(member));
    }

    // Get /members?name=홍길동 - 멤버 조회
    // Get /members - 전체 멤버 조회
    @Operation(summary = "전체 멤버 조회 또는 이름으로 검색")
    @GetMapping
    public ResponseEntity<?> searchMember(@RequestParam(required = false) String name){

        // 이름 검색
        if (name != null) {
            Role member = memberService.searchByName(name);
            if (member == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(toResponse(member));
        }

        // 전체 조회
        List<Role> members = memberService.getAllMembers();
        return ResponseEntity.ok(toResponseAll(members));
    }
    private List<Object> toResponseAll(List<Role> roles) {
        List<Object> members = new ArrayList<>();
        for (Role role : roles) {
            members.add(toResponse(role));
        }
        return members;
    }

    private Object toResponse(Role role) {
        if (role instanceof Lion lion) {
            return LionResponse.from(lion);
        } else if (role instanceof Staff staff) {
            return StaffResponse.from(staff);
        }
        return role;
    }

    // PUT /members/lions/{name} - Lion 수정
    @Operation(summary = "Lion 정보 수정")
    @PutMapping("/lions/{name}")
    public ResponseEntity<LionResponse> updateLion(@PathVariable String name, @RequestBody LionUpdateRequest request){
        Role updated = memberService.updateLion(name, request);
        if(updated == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(LionResponse.from((Lion) updated));
    }

    // PUT /members/staffs/{name} - Staff 수정
    @Operation(summary = "Staff 정보 수정")
    @PutMapping("/staffs/{name}")
    public ResponseEntity<StaffResponse> updateStaff(@PathVariable String name, @RequestBody StaffUpdateRequest request){
        Role updated = memberService.updateStaff(name, request);
        if(updated == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(StaffResponse.from((Staff) updated));
    }

    // DELETE /members/{name} - 멤버 삭제
    @Operation(summary = "멤버 삭제")
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteMember(@PathVariable String name){
        boolean success = memberService.deleteMember(name);
        if (!success) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
