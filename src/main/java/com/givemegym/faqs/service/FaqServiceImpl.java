package com.givemegym.faqs.service;

import com.givemegym.faqs.dao.FaqDao;
import com.givemegym.faqs.vo.Faq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FaqServiceImpl implements FaqService {


    @Autowired
    private FaqDao faqRepo;

    @Override
    public boolean isDup(Integer faqId) {
        return false;
    }

    @Override
    public Faq saveOrUpdate(Faq faq) {
        return faqRepo.save(faq);
    }

    @Override
    public void deleteById(Integer faqId) {
        faqRepo.deleteById(faqId);
    }

    @Override
    public Optional<Faq> findById(Integer faqId) {
        return faqRepo.findById(faqId);
    }

    @Override
    public List<Faq> findAll() {
      return faqRepo.findAll();
    }

    @Override
    public List<Faq> findByFaqCategory(String faqCategory) {
        return faqRepo.findByFaqCategory(faqCategory);
    }
}
