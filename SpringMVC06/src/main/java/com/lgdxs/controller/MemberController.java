package com.lgdxs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.lgdxs.entity.Member;
import com.lgdxs.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login.do")
	public String login() {
		return "login";
	}
	
	@GetMapping("/join.do")
	public String join() {
		return "join";
	}
	
	@PostMapping("/join.do")
	public String join(Member member) {
		memberService.join(member);
		return "redirect:/boardList.do";
	}
	
	@PostMapping("/login.do")
	public String login(Member member, HttpSession session) {
		Member info = memberService.login(member);
		System.out.println(info);
		
		if(info != null) {
			session.setAttribute("info", info);
		}
		
		return "redirect:/boardList.do";
	}
	
	@GetMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();    // 사물함 통째로 지워버림
		return "redirect:/boardList.do";
	}
	
}






