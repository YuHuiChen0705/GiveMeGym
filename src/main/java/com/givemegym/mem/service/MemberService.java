package com.givemegym.mem.service;

import java.util.List;
import java.util.Optional;

import com.givemegym.mem.vo.MemberVO;

public interface MemberService {

	/* 根據Id是否有重複 */
	boolean isDup(Integer memberId);

	/* 新增或修改問題 */
	MemberVO saveOrUpdate(MemberVO MemberVO);

	/* 刪除 根據ID刪除單一問題 */
	void deleteById(Integer memberId);

	/* 查詢 根據ID查單一問題 Optional避免空值例外 */
	Optional<MemberVO> findById(Integer memberId);

	/* 查詢所有問題 */
	List<MemberVO> findAll();

	/* 根據問題類別(四種類別)查問題 */
	List<MemberVO> findByMemberId(Integer memberId);

	// 會員註冊功能
//	MemberVO register(MemberVO member);

	// 會員登入功能
	public MemberVO login(String memberMail, String memberPassword);

}
