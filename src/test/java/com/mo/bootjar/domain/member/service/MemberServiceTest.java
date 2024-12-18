package com.mo.bootjar.domain.member.service;

import com.mo.bootjar.domain.member.Member;
import com.mo.bootjar.domain.member.dao.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Transactional
@SpringBootTest
class MemberServiceTest {

	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberRepository memberRepository;

	@BeforeEach
	void setUp() {
		Member member1 = Member.builder()
			.loginId("mo")
			.name("장현석")
			.build();

		Member member2 = Member.builder()
			.loginId("coding")
			.name("개발자")
			.build();

		memberRepository.save(member1);
		memberRepository.save(member2);
	}

	@Test
	@DisplayName("회원 일반 테스트")
	void findMemberByLoginId() {
		//given
		String loginId = "mo";

	    //when
		Member result1 = memberService.findMemberByLoginId(loginId);
		Member result2 = memberService.findMemberByLoginId(loginId);
		Member result3 = memberService.findMemberByLoginId(loginId);

	    //then
		assertNotNull(result1);
		assertNotNull(result2);
		assertNotNull(result3);
	}

	@Test
	@DisplayName("회원 캐시 테스트")
	void findCacheMemberByLoginId() {
	    //given
		String loginId = "coding";

	    //when
		var result1 = memberService.findCacheMemberByLoginId(loginId);
		var result2 = memberService.findCacheMemberByLoginId(loginId);
		var result3 = memberService.findCacheMemberByLoginId(loginId);

	    //then
		assertNotNull(result1);
		assertNotNull(result2);
		assertNotNull(result3);
	}
}