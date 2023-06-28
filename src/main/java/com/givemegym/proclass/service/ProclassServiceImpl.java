package com.givemegym.proclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.givemegym.proclass.dao.ProclassDAO;
import com.givemegym.proclass.vo.Proclass;

@Service
public class ProclassServiceImpl implements ProclassService {

	private ProclassDAO proclassDao;
	
	@Autowired
	public ProclassServiceImpl(ProclassDAO proclassDao) {
		this.proclassDao = proclassDao;
	}

	@Override
	public List<Proclass> getAllProclasses() {
		return proclassDao.findAll();
	}

	@Override
	public void save(Proclass theProclass) {
		proclassDao.save(theProclass);
	}

	@Override
	public void deleteById(int theId) {
		proclassDao.deleteById(theId);
	}
}