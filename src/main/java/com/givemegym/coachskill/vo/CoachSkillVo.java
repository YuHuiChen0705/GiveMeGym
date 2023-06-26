package com.givemegym.coachskill.vo;

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
@Table(name = "coachskill")
public class CoachSkillVo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COACHSKILL_ID")
    private Integer coachSkillId;
	@JoinColumn(name = "COACH_ID", referencedColumnName = "COACH_ID")
    private Integer coachId;
	@JoinColumn(name = "SKILL_ID", referencedColumnName = "SKILL_ID")
    private Integer skillId;

    public Integer getCoachSkillId() {
        return coachSkillId;
    }

    public void setCoachSkillId(Integer coachSkillId) {
        this.coachSkillId = coachSkillId;
    }

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }
}


