package com.givemegym.news.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.givemegym.news.dao.NewsDao;
import com.givemegym.news.vo.NewsVo;

@org.springframework.stereotype.Service
public class NewsServiceImpl implements NewsService {
	
	
	@Autowired
    private NewsDao newsDao; 
	@Override
	public boolean isDup(Integer NEWS_ID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NewsVo saveOrUpdate(NewsVo NewsVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer NewsId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<NewsVo> findById(Integer NewsId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<NewsVo> findAll() {
		// TODO Auto-generated method stub
		return newsDao.findAll();
	}

	@Override
	public List<NewsVo> findByNewsId(Integer NewsId) {
		// TODO Auto-generated method stub
		return null;
	}

}
