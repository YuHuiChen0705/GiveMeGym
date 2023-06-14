package com.givemegym.coach.vo;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "coach")

public class Coach {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COACH_ID")
	private int coachId;

	@Column(name = "COACH_NAME")
	private String name;

	@Column(name = "COACH_DETAIL")
	private String detail;

	@Lob
	@Column(name = "COACH_PIC", columnDefinition = "LONGBLOB")
	private byte[] thePic;

	@Column(name = "COACH_GENDER")
	private String gender;

	public Coach() {
	}

	public Coach(int cId, String name, String detail, byte[] thePic, String gender) {
		this.coachId = cId;
		this.name = name;
		this.detail = detail;
		this.thePic = thePic;
		this.gender = gender;
	}

	public int getcId() {
		return coachId;
	}

	public void setcId(int cId) {
		this.coachId = cId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public byte[] getThePic() {
		return thePic;
	}

	public void setThePic(byte[] thePic) {
		this.thePic = thePic;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}

//	@Override
//	public String toString() {
//		return "Coach [cId=" + cId + ", name=" + name + ", detail=" + detail + ", thePic=" + Arrays.toString(thePic)
//				+ ", gender=" + gender + "]\n";
//	}
//}
