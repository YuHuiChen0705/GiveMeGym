package com.givemegym.mem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.givemegym.mem.vo.MemberVO;

@Repository
public interface MemberDao extends JpaRepository<MemberVO, Integer> {

	List<MemberVO> findByMemberId(Integer memberId);


//	MemberVO selectForLogin(String memberMail, String memberPassword);

		public MemberVO findByMemberMail(String memberMail);
		
		public MemberVO findByMemberPassword(String memberPassword);

}
