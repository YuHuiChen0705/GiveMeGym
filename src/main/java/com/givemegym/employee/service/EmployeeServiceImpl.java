package com.givemegym.employee.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.givemegym.employee.dao.EmployeeDao;
import com.givemegym.employee.vo.Employee;



@Service
@Transactional
	public class EmployeeServiceImpl implements EmployeeService {

	    @Autowired
	    private EmployeeDao employeeDao;

	    @Override
	    public boolean isDup(Integer employeeId) {
	        return false;
	    }

	    @Override
	    public Employee saveOrUpdate(Employee employee) {

	        return employeeDao.save(employee);
	    }
	    @Override
	    public void deleteById(Integer employeeId) {
	    	employeeDao.deleteById(employeeId);
	    }

	    @Override
	    public Optional<Employee> findById(Integer employeeId) {
	        return employeeDao.findById(employeeId);
	    }

	    @Override
	    public List<Employee> findAll() {
	        return employeeDao.findAll();
	    }

		@Override
		public List<Employee> findByEmployeeId(Integer employeeId) {
			// TODO Auto-generated method stub
			return null;
		}
}