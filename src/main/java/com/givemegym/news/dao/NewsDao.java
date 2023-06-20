package com.givemegym.news.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.givemegym.news.vo.NewsVo;
import java.util.List;

@Repository
public interface NewsDao extends JpaRepository<NewsVo, Integer>{
List<NewsVo>findByNewsId(Integer newsId);

}
