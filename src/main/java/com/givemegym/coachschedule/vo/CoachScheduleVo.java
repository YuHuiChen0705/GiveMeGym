package com.givemegym.coachschedule.vo;

import lombok.*;
import javax.persistence.*;
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

	@Column(name ="COACHSCHEDULE_ID")
	  private int coachScheduleId;
	@Column(name ="COACH_ID")
	    private Integer coachId;
	@Column(name ="COACHSCHEDULE_DATE")
	    private String coachScheduleDate;
	@Column(name ="COACHSCHEDULE_TIME")
	    private String coachScheduleTime;
	@Column(name ="COACHSCHEDULE_TYPE")
	    private int coachScheduleType;
	@Column(name ="COACHSCHEDULE_CLASSID")
	    private int coachScheduleClassId;
	    
}

