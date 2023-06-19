package com.givemegym.coachschedule.vo;

import org.springframework.web.bind.annotation.ModelAttribute;

import lombok.*;
import javax.persistence.*;
import java.sql.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "coach",schema="no7")
public class CoachScheduleVo implements java.io.Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NonNull
	@ManyToOne
	@Column(name ="COACHSCHEDULE_ID")
	  private int coachScheduleId;
	@Column(name ="COACH_ID")
	    private int coachId;
	@Column(name ="COACHSCHEDULE_DATE")
	    private Date coachScheduleDate;
	@Column(name ="COACHSCHEDULE_TIME")
	    private String coachScheduleTime;
	@Column(name ="COACHSCHEDULE_TYPE")
	    private int coachScheduleType;
	@Column(name ="COACHSCHEDULE_CLASSID")
	    private int coachScheduleClassId;
	    
}

