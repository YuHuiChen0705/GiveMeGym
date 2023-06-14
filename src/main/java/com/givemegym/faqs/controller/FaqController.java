package com.givemegym.faqs.controller;

import com.givemegym.faqs.service.FaqService;
import com.givemegym.faqs.vo.Faq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class FaqController {

    @Autowired
    private FaqService faqService;

    // 根據PK查詢一筆常見問題
    @GetMapping("/faqs/{faqId}")
    public Optional<Faq> findFaq(@PathVariable Integer faqId,Model model) {
        Optional<Faq> faq = faqService.findById(faqId);
        return faq;
    }

    // 查詢常見問題列表
    @GetMapping("/faqs/all")
    public List<Faq> findAllFaq() {
        List<Faq> faqList = faqService.findAll();
        return faqList;
    }


    // 根據常見問題類別查詢所有常見問題
    @GetMapping("/findCategory/{faqCategory}")
    public List<Faq> getFaqByCategory(@PathVariable String faqCategory) {
        List<Faq> faqList = faqService.findByFaqCategory(faqCategory);
        return faqList;
    }

    //    // 導入新增常見問題的頁面
    @GetMapping("/toCreatePage")
    public String toCreate() {
        return "新增常見問題頁面";
    }

    // 導入修改常見問題的頁面
    @GetMapping("/toUpdatePage/{faqId}")
    public String toUpdate(@PathVariable Integer faqId, Model model) {
        Optional<Faq> findFaq = faqService.findById(faqId);
        model.addAttribute("Faq", findFaq.orElseThrow());
        return "修改常見問題時段的頁面";
    }

    // 新增
    @PostMapping("insert")
    public Faq createFaq(@RequestBody @Valid Faq faq) {

        Faq nFaq = faqService.saveOrUpdate(faq);
        nFaq.setFaqUpdateTime(new Date());
        return nFaq;
    }


//    // 修改常見問題
    @PutMapping("/update/{faqId}")
    public Faq updateFaq(@PathVariable Integer faqId, @RequestBody Faq faq) {

        Faq existingFaq = faqService.findById(faqId).orElse(null);

        if (existingFaq != null) {
            existingFaq.setFaqA(faq.getFaqA());
            existingFaq.setFaqQ(faq.getFaqQ());
            existingFaq.setFaqCategory(faq.getFaqCategory());
            existingFaq.setFaqUpdateTime(new Date());
            return faqService.saveOrUpdate(existingFaq);
        } else {
            return null;
        }

    }

    // 刪除
    // @DeleteMapping("/delete/{faqId}")
    // public ResponseEntity<Faq> deleteFaq(@PathVariable Integer faqId) {
    // faqService.deleteById(faqId);
    // 表示已刪除成功
    // return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    // }

    //日期
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        // java.sql.Date
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        CustomDateEditor ce = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(java.util.Date.class, ce);
    }


}
