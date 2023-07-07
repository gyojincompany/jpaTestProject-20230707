package com.gyojincompany.member.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gyojincompany.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	//<엔티티 클래스의 타입, 엔티티 기본키 타입>
	
	public List<Member> findByMname(String mname);
	

}
