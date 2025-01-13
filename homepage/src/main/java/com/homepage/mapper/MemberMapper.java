package com.homepage.mapper;

import java.util.List;

import com.homepage.domain.Member;

public interface MemberMapper {
	// 함수명이 xml의 ID이다
	public void create(Member member) throws Exception;

	public Member read(Member member) throws Exception;

	public void update(Member member) throws Exception;

	public void delete(Member member) throws Exception;

	public List<Member> list() throws Exception;
}
