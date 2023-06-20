package com.givemegym.courseshowoff.vo;

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course_showoff",schema="no7")
public class CourseShowOff {

//@ManyToOne //型別就是vo(將id改成文字)
//@JoinColumn
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name ="COURSE_SHOWOFF_ID")
	 int CourseShowOffId;

	@Column(name ="COURSESCHEDULE_ID")
	 int CoursescheduleId;

	@Column(name ="MEMBER_ID")
	 int MemberId;

	@Column(name ="COURSE_SHOWOFF_DATE")
	 Date CourseShowoffDate;

	@Column(name ="COURSE_SHOWOFF_STATE")
	 String CourseShowoffState;
	
}
