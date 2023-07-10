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
	
	@RequestMapping(value = "/memberListNew")//최근 가입 회원이 위로 오게 출력
	public String memberListNew(Model model) {		
		
		model.addAttribute("memberlist", memberService.memberListNew());
		
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
	
	@RequestMapping(value = "/searchOkNew")
	public String searchOkNew(HttpServletRequest request, Model model) {
		
		List<Member> members = memberService.searchNew(request.getParameter("mname"));
		
		model.addAttribute("memberlist", members);
		
		return "searchOk_member";
	}
	
	@RequestMapping(value = "/join")
	public String join() {
		return "joinMember";
	}
	
	@RequestMapping(value = "/joinOk")
	public String joinOk(HttpServletRequest request) {
				
		memberService.joinMember(request.getParameter("mid"), request.getParameter("mpw"), request.getParameter("mname"), request.getParameter("mage"));
		
		return "redirect:memberList";
	}

}
