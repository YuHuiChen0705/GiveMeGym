package com.givemegym.proclass.vo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.givemegym.skill.vo.Skill;

@Entity
@Table(name = "proclass")
public class Proclass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROCLASS_ID")
	private int proclassId;
	
	@OneToOne
	@JoinColumn(name = "SKILL_ID", referencedColumnName="SKILL_ID")
	private Skill skillId;
	
	@Column(name = "PROCLASS_NAME")
	private String proclassName;
	
	public Proclass() {
	}

	public Proclass(int proclassId, Skill skillId, String proclassName) {
		this.proclassId = proclassId;
		this.skillId = skillId;
		this.proclassName = proclassName;
	}

	public int getProclassId() {
		return proclassId;
	}

	public void setProclassId(int proclassId) {
		this.proclassId = proclassId;
	}

	public Skill getSkillId() {
		return skillId;
	}

	public void setSkillId(Skill skillId) {
		this.skillId = skillId;
	}

	public String getProclassName() {
		return proclassName;
	}

	public void setProclassName(String proclassName) {
		this.proclassName = proclassName;
	}
}
