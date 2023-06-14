package com.givemegym.courseshowoff.vo;

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CourseShowOff",schema="no7")
public class CourseShowOffVo {

@Id
@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)

//@ManyToOne //型別就是vo(將id改成文字)
//@JoinColumn
@Column(name ="COURSESHOWOFF_ID")
	private int CourseShowOffId;

@Column(name ="COURSESCHEDULE_ID")
	private int CoursescheduleId;

@Column(name ="MEMBER_ID")
	private int MemberId;

@Column(name ="COURSESHOWOFF_DATE")
	private Date CourseShowOffDate;

@Column(name ="COURSESHOWOFF_STATE")
	private String CourseShowOffState;
	
}
