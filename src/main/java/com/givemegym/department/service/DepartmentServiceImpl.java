package com.givemegym.department.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.givemegym.department.dao.DepartmentDao;
import com.givemegym.department.vo.Department;



@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{
	
	 	@Autowired
	    private DepartmentDao departmentDao;

	    @Override
	    public boolean isDup(Integer departmentId) {
	        return false;
	    }

	    @Override
	    public Department saveOrUpdate(Department department) {

	        return departmentDao.save(department);
	    }
	    @Override
	    public void deleteById(Integer departmentId) {
	    	departmentDao.deleteById(departmentId);
	    }

	    @Override
	    public Optional<Department> findById(Integer departmentId) {
	        return departmentDao.findById(departmentId);
	    }

	    @Override
	    public List<Department> findAll() {
	        return departmentDao.findAll();
	    }

		@Override
		public List<Department> findByDepartmentId(Integer departmentId) {
			// TODO Auto-generated method stub
			return null;
		}

}