package com.givemegym.coachskill.vo;
import org.springframework.web.bind.annotation.ModelAttribute;

import lombok.*;
import javax.persistence.*;
import java.sql.*;
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
	@ManyToOne
	@Column(name ="COACHSKILL_ID")
	private Integer coachSkillId;
	@Column(name ="COACH_ID")
	private Integer coachId;
	@Column(name ="COACHSKILL_ID")
	private Integer SKILL_ID;

}
