package com.givemegym.emp.vo;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "employee", schema = "no7")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPLOYEE_ID")
	private Integer employeeId;
	
    @Column(name = "DEPARTMENT_ID")
    private Integer departmentId;
    
    @Column(name = "EMPLOYEE_NAME")
    private String employeeName;
    
    @Column(name = "EMPLOYEE_MAIL")
    private String employeeMail;
    
    @Column(name = "EMPLOYEE_PASSWORD")
    private String employeePassword;
    
    @Column(name = "EMPLOYEE_STATE")
    private String employeeState;
}