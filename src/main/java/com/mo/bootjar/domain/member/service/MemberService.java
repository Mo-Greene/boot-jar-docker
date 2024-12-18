package com.mo.bootjar.domain.member.service;

import com.mo.bootjar.domain.member.Member;
import com.mo.bootjar.domain.member.dao.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

	@Transactional(readOnly = true)
	public Member findMemberByLoginId(String loginId) {

		return memberRepository.findByLoginId(loginId)
			.orElseThrow(() -> new RuntimeException("Not found member by loginId:" + loginId));
	}

	@Transactional(readOnly = true)
	@Cacheable(value = "users", key = "#loginId")
	public Member findCacheMemberByLoginId(String loginId) {

		return memberRepository.findByLoginId(loginId)
			.orElseThrow(() -> new RuntimeException("Not found member by loginId:" + loginId));
	}
}
