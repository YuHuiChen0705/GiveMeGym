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
	public NewsVo save(NewsVo newsVo) {
		return newsDao.save(newsVo);
	}


	@Override
	public NewsVo update(NewsVo newsVo) {
		return newsDao.save(newsVo);
	}

	@Override
	public void deleteNewsById(Integer newsId) {

		newsDao.deleteById(newsId);
	}

	@Override
	public Optional<NewsVo> findById(Integer newsId) {
		return Optional.empty();
	}


	@Override
	public List<NewsVo> findAll() {
		return newsDao.findAll();
	}



	@Override
	public NewsVo getOne_For_Update(Integer newsId) {
		Optional<NewsVo> optional = newsDao.findById(newsId);
		return optional.get();
	}

	@Override
	public List<byte[]> findByNewsId(Integer newsId) {
		return newsDao.findByNewsId(newsId);
	}

	@Override
	public NewsVo getOneNews(Integer newsId) {
		Optional<NewsVo> optional = newsDao.findById(newsId);
	    return optional.get();}


}

