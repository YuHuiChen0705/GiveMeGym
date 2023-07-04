package com.givemegym.mem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.givemegym.mem.vo.MemberVO;

@Repository
public interface MemberDao extends JpaRepository<MemberVO, Integer> {

//	List<MemberVO> findByMemberId(Integer memberId);

//	MemberVO selectForLogin(String memberMail, String memberPassword);
	
	
	public MemberVO findByMemberMail(String memberMail);

	public MemberVO findByMemberPassword(String memberPassword);

	public MemberVO findByMemberId(Integer memberId);

	@Transactional
	@Modifying
	@Query("UPDATE MemberVO m SET m.memberState = false WHERE m.memberId = :memberId")
	public int removeStatus(@Param("memberId") Integer memberId);

	@Transactional
	@Modifying
	@Query("UPDATE MemberVO m SET m.memberState = true WHERE m.memberId = :memberId")
	void recoverStatus(@Param("memberId") Integer memberId);

	@Transactional
	@Modifying
	@Query("UPDATE MemberVO m SET m.memberViolations = :memberViolations WHERE m.memberId = :memberId")
	void saveMemberViolations(@Param("memberId") Integer memberId, @Param("memberViolations") Integer memberViolations);

}
