package com.givemegym.mem.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "MEMBER", schema = "no7")
@Component
public class MemberVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEMBER_ID")
	private Integer memberId;

	@Column(name = "MEMBER_NUMBER_OF_VIOLATIONS",insertable = false)
	private Integer memberViolations;

	@NotNull
	@Column(name = "MEMBER_NAME")
	private String memberName;

	@NotNull
	@Email
	@Column(name = "MEMBER_MAIL")
	private String memberMail;

	@Column(name = "MEMBER_PASSWORD")
	private String memberPassword;

	@NotNull
	@Column(name = "MEMBER_PHONE_NUMBER")
	private String memberPhoneNumber;

	@NotNull
	@Column(name = "MEMBER_ADDRESS_REGION")
	private String memberRegion;

	@NotNull
	@Column(name = "MEMBER_ADDRESS_DISTRICT")
	private String memberDistrict;

	@NotNull
	@Column(name = "MEMBER_ADDRESS_DETAIL")
	private String memberDetail;

	@NotNull
	@Column(name = "MEMBER_BIRTHYEAR")
	private String memberBirthYear;
	
	@NotNull
	@Column(name = "MEMBER_BIRTHMONTH")
	private String memberBirthMonth;
	
	@NotNull
	@Column(name = "MEMBER_BIRTHDAY")
	private String memberBirthDay;

	@Column(name = "MEMBER_STATE",insertable = false)
	private boolean memberState;

}
	