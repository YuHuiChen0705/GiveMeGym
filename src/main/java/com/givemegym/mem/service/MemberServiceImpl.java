package com.givemegym.mem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.givemegym.mem.dao.MemberDao;
import com.givemegym.mem.vo.MemberVO;

@Repository
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;

	/* 根據Id是否有重複 */
	@Override
	public boolean isDup(Integer memberId) {
		return false;
	}

	/* 新增或修改問題 */
	@Override
	public MemberVO saveOrUpdate(MemberVO memberVO) {
		return memberDao.save(memberVO);
	}

	/* 刪除 根據ID刪除單一問題 */
	@Override
	public void deleteById(Integer memberId) {
		memberDao.deleteById(memberId);
	}

	/* 查詢所有問題 */
	@Override
	public List<MemberVO> findAll() {
		return memberDao.findAll();
	}

	/* 根據問題類別(四種類別)查問題 */
	@Override
	public List<MemberVO> findByMemberId(Integer memberId) {
		return memberDao.findByMemberId(memberId);
	}

	/* 查詢 根據ID查單一問題 Optional避免空值例外 */
	@Override
	public Optional<MemberVO> findById(Integer memberId) {
		return memberDao.findById(memberId);
	}

	@Override
	public MemberVO login(String memberMail, String memberPassword) {
		MemberVO loginMember = memberDao.findByMemberMail(memberMail);
		if (loginMember != null && loginMember.getMemberPassword().equals(memberPassword)) {
			return loginMember;
		} else {
			return null;
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

		}
	}
}
