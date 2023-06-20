package com.givemegym.coachdayoff.vo;

import java.util.Date;

public class CoachDayOff {
	private int coachDayOffId;
	private int coachId;
	private Date coachDayOffDate;
	private char coachDayOffTime;

	public int getCoachDayOffId() {
		return coachDayOffId;
	}

	public void setCoachDayOffId(int coachDayOffId) {
		this.coachDayOffId = coachDayOffId;
	}

	public int getCoachId() {
		return coachId;
	}

	public void setCoachId(int coachId) {
		this.coachId = coachId;
	}

	public Date getCoachDayOffDate() {
		return coachDayOffDate;
	}

	public void setCoachDayOffDate(Date coachDayOffDate) {
		this.coachDayOffDate = coachDayOffDate;
	}

	public char getCoachDayOffTime() {
		return coachDayOffTime;
	}

	public void setCoachDayOffTime(char coachDayOffTime) {
		this.coachDayOffTime = coachDayOffTime;
	}
}
