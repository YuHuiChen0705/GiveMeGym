package com.givemegym.faqs.controller;


import com.givemegym.faqs.service.FaqService;
import com.givemegym.faqs.vo.Faq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static java.time.LocalDateTime.now;

@Controller
@RequestMapping()
@CrossOrigin
public class FaqController {

    @Autowired
    private FaqService faqService;


    // 取得常見問題列表(渲染頁面)
    @GetMapping("/backend_faq/listAll")
    public String findAllFaq() {
        return "backend/faq/Mfaq";
    }

    @ResponseBody
    @PostMapping("/backend_faq/listAll")
    public List<Faq> findAllFaqs() {
        return faqService.findAll();
    }

    // 新增常見問題
    @ResponseBody
    @PostMapping("/backend_faq/save")
    public Faq save(@RequestBody @Valid Faq faq) {

        faq.setFaqUpdate(now());
        return faqService.saveOrUpdate(faq);
    }

    @ResponseBody
    @GetMapping("/backend_faq/getById/{faqId}")
    public Faq getById(@PathVariable Integer faqId) {
        Optional<Faq> faq = faqService.findById(faqId);
        return faq.orElse(null);
    }


    // 修改常見問題
    @ResponseBody
    @PostMapping("/backend_faq/update/{faqId}")
    public Faq update(@RequestBody @Valid Faq faq, @PathVariable Integer faqId) {
        Faq existingFaq = faqService.findById(faqId).orElse(null);


        if (existingFaq != null) {
            existingFaq.setFaqCategory(faq.getFaqCategory());
            existingFaq.setFaqQuestion(faq.getFaqQuestion());
            existingFaq.setFaqAnswer(faq.getFaqAnswer());
            existingFaq.setFaqUpdate(now());
            return faqService.saveOrUpdate(existingFaq);

        } else {
            return null;
        }
    }


    // 取得常見問題列表(渲染頁面)
    @GetMapping("/frontend_faq/listAll")
    public String findAllFaqF(ModelMap model) {
        List<Faq> faqList = faqService.findAll();
        model.addAttribute("faqList", faqList);
        return "frontend/faq/faqList";
    }


}



