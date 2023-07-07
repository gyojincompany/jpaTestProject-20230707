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

}
