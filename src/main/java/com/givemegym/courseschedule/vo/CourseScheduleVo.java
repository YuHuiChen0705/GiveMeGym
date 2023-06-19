package com.givemegym.courseschedule.vo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "CourseSchedule",schema="no7")
public class CourseScheduleVo {

@Id
@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
@Column(name ="COURSESCHEDULE_ID")
	private int CourseScheduleId;
@Column(name ="REGISTRATIONPERIOD_ID")
	private int RegisrtarrionperiodId;
@Column(name ="COACH_ID")
	private int CoachId;
@Column(name ="COURSESCHEDULE_DATE")
	private Date CourseScheduleDate;
@Column(name ="COURSESCHEDULE_TIME")
	private String CourseScheduleTime;
public static CourseScheduleVo save(CourseScheduleVo coursescheduleVo) {
	// TODO Auto-generated method stub
	return null;
}
	
		
}

