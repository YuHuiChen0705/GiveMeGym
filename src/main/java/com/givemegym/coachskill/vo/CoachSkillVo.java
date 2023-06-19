package com.givemegym.coachskill.vo;
import lombok.*;
import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "coach",schema="no7")
public class CoachSkillVo implements java.io.Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NonNull

	@Column(name ="COACHSKILL_ID")
	private Integer coachSkillId;
	@Column(name ="COACH_ID")
	private Integer coachId;
	@Column(name ="SKILL_ID")
	private Integer SKILL_ID;

}
