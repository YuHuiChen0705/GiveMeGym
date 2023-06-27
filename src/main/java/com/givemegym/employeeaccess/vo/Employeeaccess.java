package com.givemegym.employeeaccess.vo;

import javax.persistence.*;

import com.givemegym.access.vo.Access;
import com.givemegym.employee.vo.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "EMPLOYEEACCESS")
public class Employeeaccess {
	@Id
    private int employeeaccessId;
	
	@ManyToOne
	@JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;
	
	@ManyToOne
	@JoinColumn(name = "ACCESS_ID")
    private Access access;

	public int getEmployeeaccessId() {
		return employeeaccessId;
	}

	public void setEmployeeaccessId(int employeeaccessId) {
		this.employeeaccessId = employeeaccessId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Access getAccess() {
		return access;
	}

	public void setAccess(Access access) {
		this.access = access;
	}
    
}