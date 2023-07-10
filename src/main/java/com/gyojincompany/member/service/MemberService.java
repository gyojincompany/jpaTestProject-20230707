package com.gyojincompany.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyojincompany.member.entity.Member;
import com.gyojincompany.member.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	public List<Member> memberList() {
		
		List<Member> memberlist = memberRepository.findAll();//SELECT * FROM jpa_member
		
		return memberlist;
	}
	
	public List<Member> searchName(String mname) {
		
		List<Member> members = memberRepository.findByMname(mname);//select * from jpa_member where mname=?
		
		return members;
	}
	
	public void joinMember(String mid, String mpw, String mname, String mage) {
		
		Member member = new Member();
		
		member.setMid(mid);
		member.setMpw(mpw);
		member.setMname(mname);
		member.setMage(Integer.parseInt(mage));
		
		memberRepository.save(member);//insert문
	}
	
	public List<Member> memberListNew() {
		
		return memberRepository.findAllByOrderByMnumDesc();
	}
	
	public List<Member> searchNew(String mname) {
		
		return memberRepository.findByMnameOrderByMnumDesc(mname);
		
	}

}
