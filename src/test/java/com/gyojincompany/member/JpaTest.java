package com.gyojincompany.member;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

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
	
//	@Test
//	@DisplayName("회원 탈퇴(삭제) 테스트")
//	public void deleteMember() {
//		memberRepository.deleteById(2L);//delete from jpa_member where mnum=?->회원번호가 2번인 멤버 삭제
//	}
	
	@Test
	@DisplayName("회원 리스트 불러오기 테스트")
	public void memberList() {
		List<Member> memberlist = memberRepository.findAll();//select * from jpa_member
		
		for(Member member : memberlist) {
			System.out.println(member.toString());
		}
	}
	
	@Test
	@DisplayName("회원 이름 검색")
	public void searchName() {
		List<Member> memberlist = memberRepository.findByMname("홍길동");
		for(Member member : memberlist) {
			System.out.println(member.toString());
		}
	}
	
	@Test
	@DisplayName("회원 가입 테스트")
	public void joinMember() {
		
		Member member = new Member();
		//mnum은 생략-시퀀스 값이므로
		member.setMid("tiger11");
		member.setMpw("12345");
		member.setMname("이순신");
		member.setMage(22);
		
		memberRepository.save(member);//insert into jpa_member value();
		
	}
	
	@Test
	@DisplayName("특정 단어가 포함된 이름 검색")
	public void searchKeyName() {
		List<Member> memberlist = memberRepository.findByMnameLike("%길%");
		for(Member member : memberlist) {
			System.out.println(member.toString());
		}
	}
	
	
	@Test
	@DisplayName("특정 이름으로 검색하여 삭제")
	public void deleteMember() {
		memberRepository.deleteAllByMname("이순신");
	}
	
	@Test
	@DisplayName("회원 정보 수정")
	public void modifyMember() {
		
		Optional<Member> memberOptional = memberRepository.findById(15L);//mnum(기본키)가 2번인 회원 조회
		//Optional 타입으로 반환받으면 null 값으로 반환되었을때도 에러가 안나고 null값으로 저장
		
		assertTrue(memberOptional.isPresent());//null값 여부 확인(테스트용)
		
		Member member = memberOptional.get();
		member.setMname("강감찬");//이름 수정
		member.setMage(28);//나이 수정
		
		memberRepository.save(member);
	}
	
	
	
	
	
	

}
