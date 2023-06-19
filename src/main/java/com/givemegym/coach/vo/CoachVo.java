package com.givemegym.coach.vo;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.*;
import javax.persistence.*;
import java.sql.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "coach",schema="no7")
public class CoachVo implements java.io.Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NonNull
	@ManyToOne
	@Column(name ="COACH_ID")
	private Integer coachId;
	@Column(name ="COACH_NAME")
	private String coachName;
	@Column(name ="COACH_DETIAL")
	private String coachDetial;
	@Column(name ="COACH_PIC")
	private String coachPic;
	@Column(name ="COACH_GENDER")
	private String coachGender;

}

