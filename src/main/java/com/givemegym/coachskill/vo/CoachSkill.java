package com.givemegym.coachskill.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.givemegym.coach.vo.Coach;
import com.givemegym.skill.vo.Skill;

@Entity
@Table(name = "coachskill")
public class CoachSkill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COACHSKILL_ID")
	private int coachSkillId;

	@ManyToOne
	@JoinColumn(name = "COACH_ID", referencedColumnName = "COACH_ID")
	private Coach coach;

	@OneToOne
	@JoinColumn(name = "SKILL_ID", referencedColumnName = "SKILL_ID")
	private Skill skill;

	public CoachSkill() {
	}

	public CoachSkill(int coachSkillId, Coach coach, Skill skill) {
		this.coachSkillId = coachSkillId;
		this.coach = coach;
		this.skill = skill;
	}

	public int getCoachSkillId() {
		return coachSkillId;
	}

	public void setCoachSkillId(int coachSkillId) {
		this.coachSkillId = coachSkillId;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}
}
