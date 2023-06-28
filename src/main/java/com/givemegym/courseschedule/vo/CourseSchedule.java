package com.givemegym.courseschedule.vo;


import javax.persistence.*;

import com.givemegym.coach.vo.Coach;
import com.givemegym.period.vo.Period;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Course_schedule", schema = "no7")
public class CourseSchedule {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "COURSE_SCHEDULE_ID")
    private Integer courseScheduleId;

    // 關聯1方(報名時段)
    @ManyToOne()
    @JoinColumn(name = "PERIOD_ID")
    private Period period;

    // 關聯1方(教練)
    @ManyToOne()
    @JoinColumn(name = "COACH_ID")
    private Coach coach;

    @Column(name = "COURSE_SCHEDULE_DATE")
    private Date courseScheduleDate;

    @Column(name = "COURSE_SCHEDULE_TIME")
    private String courseScheduleTime;

    @Column(name = "COURSE_SCHEDULE_STATE")
    private String courseScheduleState;




}
