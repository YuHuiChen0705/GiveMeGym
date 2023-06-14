package com.givemegym.emp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.givemegym.emp.dao.AccessDao;
import com.givemegym.emp.vo.Access;

@Service
@Transactional
public class AccessServiceImpl implements AccessService {

	@Autowired
	private AccessDao accessDao;

	@Override
	public boolean isDup(Integer accessId) {
		return false;
	}

	@Override
	public Access saveOrUpdate(Access access) {

		return accessDao.save(access);
	}
	@Override
	public void deleteById(Integer accessId) {
		accessDao.deleteById(accessId);
	}

	@Override
	public Optional<Access> findById(Integer accessId) {
		return accessDao.findById(accessId);
	}

	@Override
	public List<Access> findAll() {
		return accessDao.findAll();
	}

	@Override
	public List<Access> findByAccessId(Integer accessId) {
		// TODO Auto-generated method stub
		return null;
	}
}