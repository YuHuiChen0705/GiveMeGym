package com.givemegym.coachdayoff.vo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "coachdayoff",schema="no7")
public class CoachDayoffVo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="COACHDAYOFF_ID")
	private Integer coachDayoffId;
	
	@JoinColumn(name ="COACH_ID")
	private Integer coachId;
	
	public Integer getCoachId() {
		return coachId;
	}

	public void setCoachId(Integer coachId) {
		this.coachId = coachId;
	}

	@Column(name ="COACHDAYOFF_DATE")
	private String coachDayoffDate;
	
	
	
	public Integer getCoachDayoffId() {
		return coachDayoffId;
	}

	public void setCoachDayoffId(Integer coachDayoffId) {
		this.coachDayoffId = coachDayoffId;
	}

	public String getCoachDayoffDate() {
		return coachDayoffDate;
	}

	public void setCoachDayoffDate(String coachDayoffDate) {
		this.coachDayoffDate = coachDayoffDate;
	}

//	public String getCoachDayoffTime() {
//	    if (coachDayoffTime.equals("0")) {
//	        return "早上";
//	    } else if (coachDayoffTime.equals("1")) {
//	        return "中午";
//	    } else if (coachDayoffTime.equals("2")) {
//	        return "晚上";
//	    } else {
//	        return "未知";
//	    }
//	}

	public void setCoachDayoffTime(String coachDayoffTime) {
		this.coachDayoffTime = coachDayoffTime;
	}

	@Column(name ="COACHDAYOFF_TIME")
	private String coachDayoffTime;

	public void put(String string, String timeValue) {
		// TODO Auto-generated method stub
		
	}




}
