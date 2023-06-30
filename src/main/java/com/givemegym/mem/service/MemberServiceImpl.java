package com.givemegym.mem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.givemegym.mem.dao.MemberDao;
import com.givemegym.mem.mail.mailService;
import com.givemegym.mem.vo.MemberVO;

@Repository
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	@Autowired
	private mailService mailService;

	/* 根據Id是否有重複 */
	@Override
	public boolean isDup(Integer memberId) {
		return false;
	}

	/* 新增或修改問題 */
	@Override
	public MemberVO saveOrUpdate(MemberVO memberVO) {
		MemberVO existingMember = memberDao.findByMemberMail(memberVO.getMemberMail());
		if (existingMember == null) {
			mailService.sendSuccessMail(memberVO);
			return memberDao.save(memberVO);
		} else {
			mailService.sendfailMail(memberVO);
			return null;
		}
	}

	// 會員修改資料
	public MemberVO modifyMemberData(Integer memberId, MemberVO memberVO) {
		MemberVO existingMember = memberDao.findById(memberId).orElse(null);
		if (existingMember != null) {
			existingMember.setMemberName(memberVO.getMemberName());
			existingMember.setMemberMail(memberVO.getMemberMail());
			existingMember.setMemberPhoneNumber(memberVO.getMemberPhoneNumber());
			existingMember.setMemberBirthYear(memberVO.getMemberBirthYear());
			existingMember.setMemberBirthMonth(memberVO.getMemberBirthMonth());
			existingMember.setMemberBirthDay(memberVO.getMemberBirthDay());
			existingMember.setMemberRegion(memberVO.getMemberRegion());
			existingMember.setMemberDistrict(memberVO.getMemberDistrict());
			existingMember.setMemberDetail(memberVO.getMemberDetail());
			System.out.println("Service找到memberId:" + memberId);
			return memberDao.save(existingMember);

		} else {
			return null;
		}
	}

	// 會員修改密碼
	@Override
	public MemberVO modifyPassword(String memberMail, String memberPassword, String newPassword) {
		MemberVO correctMail = memberDao.findByMemberMail(memberMail);
		System.out.println("原密碼:" + memberPassword);
		System.out.println("應該是原本的密碼"+correctMail.getMemberPassword());
		System.out.println("新密碼:" + newPassword);
		System.out.println("比對原密碼跟資料庫的密碼"+(correctMail.getMemberPassword()).equals(memberPassword));
		if (correctMail != null && ((correctMail.getMemberPassword()).equals(memberPassword))==true){
			correctMail.setMemberPassword(newPassword);
			return memberDao.save(correctMail);
		} else {
			return null;
		}
		
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
//	@Override
//	public List<MemberVO> findByMemberId(Integer memberId) {
//		return  (List<MemberVO>) memberDao.findByMemberId(memberId);
//	}

	/* 查詢 根據ID查單一問題 Optional避免空值例外 */
//	@Override
//	public Optional<MemberVO> findById(Integer memberId) {
//		return memberDao.findById(memberId);
//	}

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

	@Override
	public MemberVO findByMemberId(Integer memberId) {
		MemberVO member = memberDao.findByMemberId(memberId);
		return member;
	}

	@Override
	public void removeStatus(Integer memberId) {
		memberDao.removeStatus(memberId);
	}

	@Override
	public void recoverStatus(Integer memberId) {
		memberDao.recoverStatus(memberId);
	}

//	@Override
	public void saveMemberViolations(Integer memberId, Integer memberViolations) {
		memberDao.saveMemberViolations(memberId, memberViolations);

	}

}
