package com.givemegym.coach.vo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "coach")
public class Coach {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COACH_ID")
	private int coachId;
	
	@Column(name = "COACH_NAME")
	private String coachName;
	
	@Column(name = "COACH_DETAIL")
	private String coachDetail;
	
	@Column(name = "COACH_PIC", columnDefinition = "LONGBLOB")
	private byte[] coachPic;
	
	@Column(name = "COACH_GENDER")
	private String coachGender;
	
	public Coach() {
	}

	public Coach(int coachId, String coachName, String coachDetail,
			byte[] coachPic, String coachGender) {
		this.coachId = coachId;
		this.coachName = coachName;
		this.coachDetail = coachDetail;
		this.coachPic = coachPic;
		this.coachGender = coachGender;
	}

	public int getCoachId() {
		return coachId;
	}

	public void setCoachId(int coachId) {
		this.coachId = coachId;
	}

	public String getCoachName() {
		return coachName;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	public String getCoachDetail() {
		return coachDetail;
	}

	public void setCoachDetail(String coachDetail) {
		this.coachDetail = coachDetail;
	}

	public byte[] getCoachPic() {
		return coachPic;
	}

	public void setCoachPic(byte[] coachPic) {
		this.coachPic = coachPic;
	}

	public String getCoachGender() {
		return coachGender;
	}

	public void setCoachGender(String coachGender) {
		this.coachGender = coachGender;
	}
}
