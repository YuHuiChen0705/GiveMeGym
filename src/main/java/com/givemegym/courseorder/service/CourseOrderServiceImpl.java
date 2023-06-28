package com.givemegym.courseorder.service;

import com.givemegym.courseorder.dao.CourseOrderDao;
import com.givemegym.courseorder.vo.CourseOrder;
import com.givemegym.mem.vo.MemberVO;
import com.givemegym.period.dao.PeriodDao;
import com.givemegym.period.vo.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional
public class CourseOrderServiceImpl implements CourseOrderService {

    @Autowired
    private CourseOrderDao courseOrderDao;

    @Autowired
    PeriodDao periodDao;


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
    public void saveOrder(Integer periodId, MemberVO member) {

        Period period = periodDao.findById(periodId).get();
        CourseOrder order = new CourseOrder();
        order.setPeriod(period);
        order.setMember(member);
        order.setCourseOrderTotalPrice(period.getCoursePrice());
        order.setCourseOrderDate(new Date());
        order.setCourseOrderState("已成立");
        courseOrderDao.save(order);
    }


    @Override
    public void sendNotifyEmail(String recipient, String subject, String message) {

    }


//    // 寄信
//    @Override
//    public void sendNotifyEmail(String recipient, String subject, String message) {
//        MimeMessagePreparator messagePreparator = mimeMessage -> {
//            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
//            messageHelper.setFrom("chloe830715@gmail.com");
//            messageHelper.setTo(recipient);
//            messageHelper.setSubject(subject);
//            messageHelper.setText(message, true);
//        };
//        try {
//            mailSender.send(messagePreparator);
//            System.out.println("sent");
//        } catch (MailException e) {
//            System.out.println(e);
//        }
//    }

    @Override
    public void updateCourseOrderStateToOffByPeriod(Period period) {
        courseOrderDao.updateCourseOrderStateToOffByPeriod(period);

    }

    @Override
    public void updateCourseOrderStateToOnByPeriod(Period period) {
        courseOrderDao.updateCourseOrderStateToOnByPeriod(period);

    }

    @Override
    public List<CourseOrder> findByCourseOrderStateAndPeriod(String courseOrderState, Period period) {
        return courseOrderDao.findByCourseOrderStateAndPeriod(courseOrderState, period);
    }

    @Override
    public CourseOrder findCourseOrderByMemberAndPeriod(MemberVO member, Period period) {
        return courseOrderDao.findCourseOrderByMemberAndPeriod(member, period);
    }


    @Override
    public Set<CourseOrder> findByCourseOrderStateAndMember(String CourseOrderState, MemberVO member) {
//        Set<CourseOrder> orders = courseOrderDao.findByCourseOrderStateAndMember(CourseOrderState, member);
//
//        // 創建新的集合用來裝上課時段
//        Set<CourseSchedule> courseSchedules = new HashSet<>();
//        for (CourseOrder order : orders) {
//            Period period = order.getPeriod();
//            if (period != null) {
//                Set<CourseSchedule> schedules = period.getSchedules();
//                // 上課時段加到集合中
//                courseSchedules.addAll(schedules);
//            }
//        }
        return courseOrderDao.findByCourseOrderStateAndMember(CourseOrderState, member);
    }


}
