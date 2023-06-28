package com.givemegym.employee.vo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.givemegym.department.vo.Department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class Employee {    
    
    
    @Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeMail="
				+ employeeMail + ", employeePassword=" + employeePassword + ", employeeState=" + employeeState
				+ ", department=" + department + "]";
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    public int getEmployeeId() {
        return employeeId;
    }
    
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    
    private String employeeName;
    
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    
    
    private String employeeMail;
    
    public String getEmployeeMail() {
        return employeeMail;
    }
    
    public void setEmployeeMail(String employeeMail) {
        this.employeeMail = employeeMail;
    }

    private String employeePassword;
    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }
    
    private String employeeState;
    public String getEmployeeState() {
        return employeeState;
    }

    public void setEmployeeState(String employeeState) {
        this.employeeState = employeeState;
    }
    
    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}