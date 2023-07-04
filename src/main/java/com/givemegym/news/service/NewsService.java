package com.givemegym.news.service;
import com.givemegym.news.dao.NewsDao;
import com.givemegym.news.vo.NewsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service("newsService")
public interface NewsService {

    /*新增或修改最新消息*/
    NewsVo save(NewsVo NewsVo);

    /*新增或修改最新消息*/
    NewsVo update(NewsVo NewsVo);

    /*刪除 根據ID刪除單一最新消息*/
    void deleteNewsById(Integer NewsId);

    Optional<NewsVo> findById(Integer newsId);

    /*查詢所有最新消息*/
    List<NewsVo> findAll();

    NewsVo getOne_For_Update(Integer newsId);

    /*根據id查照片*/
    List<byte[]> findByNewsId(Integer newsId);

    NewsVo getOneNews(Integer newsId);

}
