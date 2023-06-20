package com.givemegym.news.service;

import com.givemegym.news.dao.NewsDao;
import com.givemegym.news.vo.NewsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service("newsService")
public interface NewsService {

    boolean isDup(Integer NEWS_ID);

    /*新增或修改問題*/
    NewsVo saveOrUpdate(NewsVo NewsVo);

    /*刪除 根據ID刪除單一問題*/
    void deleteById(Integer NewsId);

    /*查詢 根據ID查單一問題 Optional避免空值例外*/
    Optional<NewsVo> findById(Integer NewsId);

    /*查詢所有問題*/
    List<NewsVo> findAll();
    //  VO型別



    /*根據問題類別(四種類別)查問題*/
//    List<NewsVo> findByNewsId(Integer NewsId);


}
