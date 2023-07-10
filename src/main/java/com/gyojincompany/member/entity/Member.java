package com.gyojincompany.member.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//JPA설정
@Entity//Member 클래스를 엔티티로 선언
@Table(name = "jpa_member")//엔티티와 매핑할 DB의 테이블 이름 설정
@SequenceGenerator(
		name = "JPAMEMBER_SEQ_GENERATOR",//시퀀스 제너레이터 이름
		sequenceName = "jpamember_seq",//시퀀스 이름
		initialValue = 1,
		allocationSize = 1		
)

//lombok설정
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	
	@Id //매핑될 테이블의 기본키로 설정
	@Column(name = "mnum") //실제 DB테이블의 필드이름을 설정
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JPAMEMBER_SEQ_GENERATOR")
	private Long mnum;//회원 번호(자동으로 1~ 시퀀스로 들어가는 회원번호)
	
	@Column(name = "mid", nullable = false, length = 20)
	private String mid;
	
	@Column(name = "mpw", length = 20, nullable = false)
	private String mpw;
	
	@Column(name = "mname", length = 30, nullable = false)
	private String mname;//이름
	
	@Column(name = "mage")
	private int mage;//나이

}
