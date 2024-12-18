package com.mo.bootjar.domain.member.controller;

import com.mo.bootjar.domain.member.Member;
import com.mo.bootjar.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@GetMapping("/api/member")
	public ResponseEntity<Member> getCacheMember(@RequestParam(name = "loginId", required = false) String loginId) {
		Member result = memberService.findMemberByLoginId(loginId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
