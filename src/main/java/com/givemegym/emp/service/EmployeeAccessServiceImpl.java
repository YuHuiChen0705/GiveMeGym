package com.givemegym.emp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.givemegym.emp.dao.EmployeeAccessDao;
import com.givemegym.emp.vo.EmployeeAccess;

@Service
@Transactional
public class EmployeeAccessServiceImpl implements EmployeeAccessService{
	
	 	@Autowired
	    private EmployeeAccessDao employeeaccessDao;

	    @Override
	    public boolean isDup(Integer employeeaccessId) {
	        return false;
	    }

	    @Override
	    public EmployeeAccess saveOrUpdate(EmployeeAccess employeeaccess) {

	        return employeeaccessDao.save(employeeaccess);
	    }
	    
	    @Override
	    public void deleteById(Integer employeeaccessId) {
	    	employeeaccessDao.deleteById(employeeaccessId);
	    }

	    @Override
	    public Optional<EmployeeAccess> findById(Integer employeeaccessId) {
	        return employeeaccessDao.findById(employeeaccessId);
	    }

	    @Override
	    public List<EmployeeAccess> findAll() {
	        return employeeaccessDao.findAll();
	    }

		@Override
		public List<EmployeeAccess> findByEmployeeAccessId(Integer employeeaccessId) {
			// TODO Auto-generated method stub
			return null;
		}

}
