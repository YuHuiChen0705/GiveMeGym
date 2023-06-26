package com.givemegym.courseorder.service;

import com.givemegym.courseorder.dao.CourseOrderDao;
import com.givemegym.courseorder.vo.CourseOrder;
import com.givemegym.member_B.vo.Member;
import com.givemegym.period.dao.PeriodDao;
import com.givemegym.period.vo.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
@Transactional
public class CourseOrderServiceImpl implements CourseOrderService {

    @Autowired
    private CourseOrderDao courseOrderDao;

    @Autowired
    PeriodDao periodDao;

    @Autowired
    JavaMailSender mailSender;


    @Override
    public CourseOrder saveOrUpdate(CourseOrder courseOrder) {
        return courseOrderDao.save(courseOrder);
    }

    @Override
    public Optional<CourseOrder> findById(Integer courseOrderId) {
        return courseOrderDao.findById(courseOrderId);
    }

    @Override
    public List<CourseOrder> findCourseOrderByPeriod(Period period) {
        return courseOrderDao.findCourseOrderByPeriod(period);
    }

    @Override
    public List<CourseOrder> findByMemberId(Integer memberId) {
        return courseOrderDao.findByMemberId(memberId);
    }


    @Override
    public List<CourseOrder> findAll() {
        return courseOrderDao.findAll();
    }


    // 會員下單
    @Override
    public void saveOrder(Integer periodId, Member member) {

        Period period = periodDao.findById(periodId).get();
        CourseOrder order = new CourseOrder();
        order.setPeriod(period);
        order.setMember(member);
        order.setCourseOrderTotalPrice(period.getCoursePrice());
        order.setCourseOrderDate(new Date());
        order.setCourseOrderState("已付款");
        courseOrderDao.save(order);
    }

    @Override
    public List<CourseOrder> findByCourseOrderStateAndMember(String CourseOrderState, Member member) {
        return null;
    }

    // 寄信
    @Override
    public void sendNotifyEmail(String recipient, String subject, String message) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("chloe830715@gmail.com");
            messageHelper.setTo(recipient);
            messageHelper.setSubject(subject);
            messageHelper.setText(message, true);
        };
        try {
            mailSender.send(messagePreparator);
            System.out.println("sent");
        } catch (MailException e) {
            System.out.println(e);
        }
    }

    @Override
    public void updateCourseOrderStateToOffByPeriod(Period period) {
        courseOrderDao.updateCourseOrderStateToOffByPeriod(period);

    }

    @Override
    public void updateCourseOrderStateToOnByPeriod(Period period) {
        courseOrderDao.updateCourseOrderStateToOnByPeriod(period);

    }

    @Override
    public Set<CourseOrder> findByCourseOrderStateAndPeriod(String courseOrderState, Period period) {
        return courseOrderDao.findByCourseOrderStateAndPeriod(courseOrderState, period);
    }


}
