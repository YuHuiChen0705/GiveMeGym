package com.givemegym.employeeaccess.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.givemegym.employeeaccess.dao.EmployeeaccessDao;
import com.givemegym.employeeaccess.vo.Employeeaccess;

@Service
@Transactional
	public class EmployeeaccessServiceImpl implements EmployeeaccessService {

	    @Autowired
	    private EmployeeaccessDao employeeaccessDao;

	    @Override
	    public boolean isDup(Integer employeeaccessId) {
	        return false;
	    }

	    @Override
	    public Employeeaccess saveOrUpdate(Employeeaccess employeeaccess) {

	        return employeeaccessDao.save(employeeaccess);
	    }
	    @Override
	    public void deleteById(Integer employeeaccessId) {
	    	employeeaccessDao.deleteById(employeeaccessId);
	    }

	    @Override
	    public Optional<Employeeaccess> findById(Integer employeeaccessId) {
	        return employeeaccessDao.findById(employeeaccessId);
	    }

	    @Override
	    public List<Employeeaccess> findAll() {
	        return employeeaccessDao.findAll();
	    }

		@Override
		public List<Employeeaccess> findByEmployeeaccessId(Integer employeeaccessId) {
			// TODO Auto-generated method stub
			return null;
		}
}