package com.givemegym.courseschedule;

import com.givemegym.coach.vo.Coach;
import com.givemegym.mem.vo.MemberVO;
import com.givemegym.period.vo.Period;

import javax.persistence.*;
import java.sql.Date;

public class ScheduleInfoDto<CourseSchedule> {

    @Column(name = "COURSE_ORDER_ID")
    private Integer courseOrderId;

    @Column(name = "COACH_ID")
    private Coach coach;

    @Column(name = "COURSE_SCHEDULE_DATE")
    private Date courseScheduleDate;

    @Column(name = "COURSE_SCHEDULE_TIME")
    private String courseScheduleTime;

    @Column(name = "COURSE_SCHEDULE_STATE")
    private String courseScheduleState;

    @ManyToOne()
    @JoinColumn(name = "PERIOD_ID")
    private Period period;

    @ManyToOne()
    @JoinColumn(name = "MEMBER_ID")
    private MemberVO member;


}
