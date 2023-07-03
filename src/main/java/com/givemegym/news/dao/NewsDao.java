package com.givemegym.news.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.givemegym.news.vo.NewsVo;
import java.util.List;

@Repository
public interface NewsDao extends JpaRepository<NewsVo, Integer>{

@Query("SELECT n.newsImg FROM NewsVo n")
    List<byte[]> findByNewsId(@Param("newsImg")Integer newsId);


}
