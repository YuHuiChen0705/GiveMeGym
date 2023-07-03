package com.givemegym.mem.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.givemegym.mem.vo.MemberVO;

@Component
public class mailService {

	@Autowired
	private JavaMailSender mailSender;

	public String sendSuccessMail(MemberVO memberVO) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("givemegymservice@gmail.com");
		message.setTo(memberVO.getMemberMail());
		message.setSubject("GiveMeGym___【註冊成功通知】");
		message.setText("Hello,親愛的" + "\t" + memberVO.getMemberName() + "您好~" + "\n" + "恭喜成為GiveMeGym的一員，" + "\n" + "\n"
				+ "以下為2023年7月的優惠商品，點擊連結就能迅速瀏覽，" + "\n" + "http://localhost:8080/shopAllProduct" + "\n" + "\n"
				+ "以下為2023年7月的團體課程資訊，點擊連結就能迅速瀏覽，" + "\n" + "http://localhost:8080/frontend_course/listAll" + "\n" + "\n"
				+ "\n" + "此為系統自動發信請勿直接回覆，謝謝。");
		mailSender.send(message);
		return "frontend/member/login";
	}

	public String sendfailMail(MemberVO memberVO) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("givemegymservice@gmail.com");
		message.setTo(memberVO.getMemberMail());
		message.setSubject("GiveMeGym___【註冊失敗通知】");
		message.setText(
				"Hello,親愛的"+"\t"+ memberVO.getMemberName()+"您好~"
				+ "\n" + "很抱歉，您已是GiveMeGym的一員，請勿重複註冊，" 
				+ "\n" + "感謝您的雙倍支持，謝謝!"
				+ "\n"+ "\n"+ "\n" + "此為系統自動發信請勿直接回覆，謝謝。");
		mailSender.send(message);
		return "frontend/member/login";
	}

}
