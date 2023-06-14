package com.givemegym.news.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.givemegym.news.vo.NewsVo;

@Repository
public interface NewsDao extends JpaRepository<NewsVo, Integer>{


}
