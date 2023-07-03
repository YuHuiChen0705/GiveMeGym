package com.givemegym.coachdayoff.vo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.givemegym.coach.vo.Coach;

@Entity
@Table(name = "coachdayoff")
public class CoachDayOff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COACHDAYOFF_ID")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "COACH_ID", referencedColumnName="COACH_ID")
	private Coach coach;
	
	@Column(name = "COACHDAYOFF_DATE")
	private LocalDate date;
	
	@Column(name = "COACHDAYOFF_TIME")
	private char time;
	
	public CoachDayOff() {
	}

	public CoachDayOff(int id, Coach coach, LocalDate date, char time) {
		this.id = id;
		this.coach = coach;
		this.date = date;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public char getTime() {
		return time;
	}

	public void setTime(char time) {
		this.time = time;
	}
}
