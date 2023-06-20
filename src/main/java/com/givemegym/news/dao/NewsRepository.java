package com.givemegym.news.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.givemegym.news.vo.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer>{


}
