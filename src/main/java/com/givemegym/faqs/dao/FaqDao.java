package com.givemegym.faqs.dao;

import com.givemegym.faqs.vo.Faq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FaqDao extends JpaRepository<Faq, Integer> {

    List<Faq> findFaqByfaqCategory(String faqCategory);


}

