package com.givemegym.faqs.service;


import com.givemegym.faqs.vo.Faq;

import java.util.List;
import java.util.Optional;

public interface FaqService {

    /*根據Id檢查是否重複*/
    boolean isDup(Integer faqId);

    /*新增或修改問題*/
    Faq saveOrUpdate(Faq faq);

    /*刪除 根據ID刪除單一問題*/
    void deleteById(Integer faqId);

    /*查詢 根據ID查單一問題 Optional避免空值例外*/
    Optional<Faq> findById(Integer faqId);

    /*查詢所有問題*/
    List<Faq> findAll();

    /*根據問題類別(四種類別)查問題*/
    List<Faq> findByFaqCategory(String faqCategory);


}

