package com.mo.bootjar.domain.member;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;

	@Column(name = "login_id", length = 100, nullable = false)
	private String loginId;

	@Column(name = "name", length = 10, nullable = false)
	private String name;

	@Builder
	public Member(String loginId, String name) {
		this.loginId = loginId;
		this.name = name;
	}
}
