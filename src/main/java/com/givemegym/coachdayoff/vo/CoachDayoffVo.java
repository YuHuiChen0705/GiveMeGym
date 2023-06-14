package com.givemegym.coachdayoff.vo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.NonNull;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.ModelAttribute;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "coach",schema="no7")
public class CoachDayoffVo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NonNull
	@ManyToOne
	private Integer coachDayoffId;
	@Column(name ="COACHDAYOFF_ID")
	private String coachId;
	@Column(name ="COACH_ID")
	private String coachDayoffDate;
	@Column(name ="COACHDAYOFF_DATE")
	private String coachDayoffTime;
	@Column(name ="COACHDAYOFF_TIME")
	private String coachGender;


}
