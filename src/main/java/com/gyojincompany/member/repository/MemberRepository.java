package com.gyojincompany.member.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.gyojincompany.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	//<엔티티 클래스의 타입, 엔티티 기본키 타입>
	
	public List<Member> findByMname(String mname);
	//SELECT * FROM jpa_member WHERE mname=#{param1}
	
	public List<Member> findAllByOrderByMnumDesc();
	//SELECT * FROM jpa_member ORDER BY mnum DESC
	
	public List<Member> findByMnameOrderByMnumDesc(String mname);
	//SELECT * FROM jpa_member WHERE mname=? ORDER BY mnum DESC
	
	public List<Member> findByMidAndMpw(String mid, String mpw);
	//SELECT * FROM jpa_member WHERE mid=? AND mpw=?
	
	public List<Member> findByMageLessThan(int mage);//몇살 미만만 검색
	public List<Member> findByMageLessThanEqual(int mage);//몇살 이하만 검색
	public List<Member> findByMageGreaterThan(int mage);//몇살 초과만 검색
	public List<Member> findByMageGreaterThanEqual(int mage);//몇살 이상만 검색
	public List<Member> findByMageBetween(int mage1, int mage2);//mage1 <= x <= mage2
	
	public List<Member> findByMnameStartingWith(String firstName);//특정단어로 시작
	public List<Member> findByMnameEndingWith(String lastName);//특정단어로 끝남
	public List<Member> findByMnameContaining(String midName);//특정단어가 포함
	public List<Member> findByMnameLike(String namekey);//특정단어가 포함
	
	@Transactional
	public void deleteAllByMname(String mname);//이름으로 검색하여 삭제
	
}
