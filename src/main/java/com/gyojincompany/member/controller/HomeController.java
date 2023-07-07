package com.gyojincompany.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gyojincompany.member.entity.Member;
import com.gyojincompany.member.repository.MemberRepository;
import com.gyojincompany.member.service.MemberService;

@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/memberList")
	public String memberList(Model model) {
		
		List<Member> memberlist = memberService.memberList();
		
		model.addAttribute("memberlist", memberlist);
		
		return "member_list";
	}
	
	@RequestMapping(value = "/search")
	public String search() {
		return "search_member";
	}
	
	@RequestMapping(value = "/searchOk")
	public String searchOk(HttpServletRequest request, Model model) {
		
		List<Member> members = memberService.searchName(request.getParameter("searchName"));
		
		model.addAttribute("memberlist", members);
		
		return "searchOk_member";
	}

}
