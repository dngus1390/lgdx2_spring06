package com.lgdxs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgdxs.entity.Member;
import com.lgdxs.repository.MemberRepository;


@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;

	public void join(Member member) {
		memberRepository.save(member);
		
	}

	public Member login(Member member) {
		String id = member.getId();
		String pw = member.getPw();
		return memberRepository.findByIdAndPw(id, pw);
		
	}


}
