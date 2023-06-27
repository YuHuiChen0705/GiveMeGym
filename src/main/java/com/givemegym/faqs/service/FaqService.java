package com.givemegym.faqs.service;


import com.givemegym.faqs.vo.Faq;

import java.util.List;
import java.util.Optional;

public interface FaqService {


    /*修改或修改問題*/
    Faq saveOrUpdate(Faq faq);

    /*刪除 根據ID刪除單一問題*/
    void delete(Integer faqId);

    /*查詢所有問題*/
    List<Faq> findAll();


    Optional<Faq> findById(Integer faqId);

    List<Faq> findFaqByfaqCategory(String faqCategory);
}

