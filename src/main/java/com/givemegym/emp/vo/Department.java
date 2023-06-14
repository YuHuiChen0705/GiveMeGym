package com.givemegym.emp.vo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "department", schema = "no7")
public class Department {
	@Id
	private Long id;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "DEPARTMENT_ID")
    private int departmentId;
	
	@Column(name = "DEPARTMENT_NANE")
    private String departmentName;
}
