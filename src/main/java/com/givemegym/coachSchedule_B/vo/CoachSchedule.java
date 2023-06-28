package com.givemegym.coachSchedule_B.vo;

import com.givemegym.coach.vo.Coach;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "coachschedule", schema = "no7")
public class CoachSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COACHSCHEDULE_ID", nullable = false)
    private Integer coachScheduleId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "COACH_ID", nullable = false)
    private Coach coach;

    @Column(name = "COACHSCHEDULE_DATE", nullable = false)
    private Date coachScheduleDate;

    @Column(name = "COACHSCHEDULE_TIME")
    private String coachScheduleTime;

    @Column(name = "COACHSCHEDULE_TYPE")
    private Integer coachScheduleType;

    @Column(name = "COACHSCHEDULE_CLASSID")
    private Integer coachScheduleClassId;


}