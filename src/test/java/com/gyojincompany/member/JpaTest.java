package com.gyojincompany.member;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.gyojincompany.member.entity.Member;
import com.gyojincompany.member.repository.MemberRepository;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class JpaTest {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Test
	@DisplayName("회원 탈퇴(삭제) 테스트")
	public void deleteMember() {
		memberRepository.deleteById(2L);//delete from jpa_member where mnum=?->회원번호가 2번인 멤버 삭제
	}
	
	@Test
	@DisplayName("회원 리스트 불러오기 테스트")
	public void memberList() {
		List<Member> memberlist = memberRepository.findAll();//select * from jpa_member
		
		for(Member member : memberlist) {
			System.out.println(member.toString());
		}
	}
	

}
