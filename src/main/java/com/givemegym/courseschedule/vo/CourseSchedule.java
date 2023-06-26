package com.givemegym.courseschedule.vo;

import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.givemegym.coach.vo.CoachVo;
import com.givemegym.period.vo.Period;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Courseschedule", schema = "no7")
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
    private CoachVo coach;

    @NotNull(message = "請輸入上課日期")
    @Future(message = "別活在過去")
    @Column(name = "COURSE_SCHEDULE_DATE")
    private Date courseScheduleDate;

    @NotBlank(message = "請輸入上課時段")
    @Column(name = "COURSE_SCHEDULE_TIME")
    private String courseScheduleTime;

    @Column(name = "COURSE_SCHEDULE_STATE")
    private String courseScheduleState;


}
