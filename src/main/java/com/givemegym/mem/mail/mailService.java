package com.givemegym.mem.mail;

import com.givemegym.courseorder.vo.CourseOrder;
import com.givemegym.period.vo.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.givemegym.mem.vo.MemberVO;

import java.util.Set;

@Component
public class mailService {

    @Autowired
    private JavaMailSender mailSender;

    public String sendSuccessMail(MemberVO memberVO) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("givemegymservice@gmail.com");
        message.setTo(memberVO.getMemberMail());
        message.setSubject("GiveMeGym___【註冊成功通知】");
        message.setText("Hello,親愛的" + "\t" + memberVO.getMemberName() + "您好~"
                + "\n" + "恭喜成為GiveMeGym的一員"
                + "\n" + "以下為2023年7月的優惠商品，點擊連結就能迅速瀏覽"
                + "\n" + "http://localhost:8080/shopAllProduct"
                + "\n" + "以下為2023年7月的團體課程資訊，點擊連結就能迅速瀏覽"
                + "\n" + "http://localhost:8080/frontend_course/listAll"
                + "\n" + "\n" + "\n" + "此為系統自動發信請勿直接回覆，謝謝。");
        mailSender.send(message);
        return "frontend/member/login";
    }

    public String sendfailMail(MemberVO memberVO) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("givemegymservice@gmail.com");
        message.setTo(memberVO.getMemberMail());
        message.setSubject("GiveMeGym___會員註冊驗證信件");
        message.setText("Hello," + memberVO.getMemberName()
                + "\n" + "很抱歉，您已是GiveMeGym的一員"
                + "\n" + "感謝您的支持，謝謝!");
        mailSender.send(message);
        return "frontend/member/login";
    }

    public void sendCancelMail(Period period) {
        Set<CourseOrder> orders = period.getOrders();
        for (CourseOrder order : orders) {
            String memberMail = order.getMember().getMemberMail();
            String memberName = order.getMember().getMemberName();
            SimpleMailMessage message = new SimpleMailMessage();
            String courseName = order.getPeriod().getCourse().getCourseName();
            message.setFrom("givemegymservice@gmail.com");
            message.setTo(memberMail);
            message.setSubject("GiveMeGym___團課未成團信件");
            message.setText("Hello," + memberName
                            + "\n" + "很抱歉，要告知您所報名的" + courseName + "未成團"
                            + "\n" + "我們將於7-10天進行退款!請您不用擔心，我們會儘快處理您的退款事宜。"
                            + "\n" + "若您有任何問題或需要進一步協助，請隨時與我們聯繫。"
                            + "\n" + "再次感謝您對GiveMeGym的支持，我們期待能為您提供更多優質的服務！");
                    mailSender.send(message);
        }
    }


}
