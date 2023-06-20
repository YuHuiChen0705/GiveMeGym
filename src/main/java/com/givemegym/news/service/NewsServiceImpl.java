package com.givemegym.news.service;

import com.givemegym.news.dao.NewsDao;
import com.givemegym.news.vo.NewsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDao newsDao;
	@Override
	public boolean isDup(Integer newsID) {
		return false;
	}

	@Override
	public NewsVo saveOrUpdate(NewsVo newsVo) {
		return newsDao.save(newsVo);
	}

	@Override
	public void deleteById(Integer newsId) {
        newsDao.deleteById(newsId);
	}

	@Override
	public Optional<NewsVo> findById(Integer newsId) {
		return newsDao.findById(newsId);
	}

	@Override
	public List<NewsVo> findAll() {
		return newsDao.findAll();
	}

//	@Override
//	public List<NewsVo> findByNewsId(Integer NewsId) {
//		return null;
//	}
}
