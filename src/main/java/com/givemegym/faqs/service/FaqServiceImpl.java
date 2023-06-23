package com.givemegym.faqs.service;

import com.givemegym.faqs.dao.FaqDao;
import com.givemegym.faqs.vo.Faq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FaqServiceImpl implements FaqService {

    @Autowired
    private FaqDao faqDao;

    @Override
    public Faq saveOrUpdate(Faq faq) {
        return faqDao.save(faq);
    }

    @Override
    public void delete(Integer faqId) {
        faqDao.deleteById(faqId);
    }

    @Override
    public List<Faq> findAll() {
        return faqDao.findAll();
    }

    @Override
    public Optional<Faq> findById(Integer faqId) {
        return faqDao.findById(faqId);
    }

    @Override
    public List<Faq> findFaqByfaqCategory(String faqCategory) {
        return faqDao.findFaqByfaqCategory(faqCategory);
    }
}
