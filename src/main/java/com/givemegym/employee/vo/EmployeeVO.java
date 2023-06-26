package com.givemegym.employee.vo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "EMPLOYEE", schema = "no7")
public class EmployeeVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPLOYEE_ID")
    private Integer employeeId;
    
    @NotNull
    private Integer departmentId;
    
    @NotNull
    private String employeeName;
    
    @NotNull
    @Column(name="EMPLOYEE_MAIL")
    private String employeeMail;
    
    @NotNull
    @Column(name="EMPLOYEE_PASSWORD")
    private String employeePassword;
    
    @NotNull
    private String employeeState;

    
}