package com.givemegym.proclassorder.vo;

import java.sql.Date;
import java.sql.Timestamp;

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
@Table(name = "PROCLASSORDER", schema = "no7")
public class ProclassOrderVo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROCLASSORDER_ID")
	private Integer proClassOrderId;

	@JoinColumn(name = "PROCLASS_ID", referencedColumnName = "PROCLASS_ID")
	private Integer proClassId;

	@Column(name = "MEMBER_ID")
	private Integer memberId;

	@Column(name = "PROCLASS_ATTEND", columnDefinition = "BOOLEAN DEFAULT NULL")
	private Boolean proClassAttend;

	@Column(name = "PROCLASS_TIME")
	private char proClassTime;

	@Column(name = "PROCLASS_DATE")
	private Timestamp proClassDate;

	@Column(name = "COACH_ID")
	private Integer coachId;

	@Column(name = "PROCLASSORDER_STATE", columnDefinition = "CHAR(1) DEFAULT '0'")
	private char proClassOrderState;

	@Column(name = "PROCLASSORDER_DATE")
	private Timestamp proClassOrderDate;

	public Integer getProClassOrderId() {
		return proClassOrderId;
	}

	public void setProClassOrderId(Integer proClassOrderId) {
		this.proClassOrderId = proClassOrderId;
	}

	public Integer getProClassId() {
		return proClassId;
	}

	public void setProClassId(Integer proClassId) {
		this.proClassId = proClassId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Boolean getProClassAttend() {
		return proClassAttend;
	}

	public void setProClassAttend(Boolean proClassAttend) {
		this.proClassAttend = proClassAttend;
	}

	public char getProClassTime() {
		return proClassTime;
	}

	public void setProClassTime(char proClassTime) {
		this.proClassTime = proClassTime;
	}

	public Timestamp getProClassDate() {
		return proClassDate;
	}

	public void setProClassDate(Timestamp proClassDate) {
		this.proClassDate = proClassDate;
	}

	public Integer getCoachId() {
		return coachId;
	}

	public void setCoachId(Integer coachId) {
		this.coachId = coachId;
	}

	public char getProClassOrderState() {
		return proClassOrderState;
	}

	public void setProClassOrderState(char proClassOrderState) {
		this.proClassOrderState = proClassOrderState;
	}

	public Timestamp getProClassOrderDate() {
		return proClassOrderDate;
	}

	public void setProClassOrderDate(Timestamp proClassOrderDate) {
		this.proClassOrderDate = proClassOrderDate;
	}

}
