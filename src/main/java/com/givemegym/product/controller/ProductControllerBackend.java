package com.givemegym.product.controller;

import com.givemegym.category.vo.Category;
import com.givemegym.product.service.ProductService;
import com.givemegym.product.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Backend-product")
public class ProductControllerBackend {
    @Autowired
    private ProductService productService;

    @GetMapping("/getAllProduct")
    public String findAllProduct(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("productList",productList);
        return "backend/product/backend_pdList";
    }

//    @GetMapping("/getCategoryProduct")
//    @ModelAttribute()
//    public List<Category> findCategoryProduct(Model model){
//        List<Category> categoryProductList = CategoryService.findAll();
//        return categoryProductList;
//    }

    // 導入新增商品時段的頁面
    @GetMapping("/addProduct")
    public String addProduct() {
        return "backend/product/backend_pdInsert";
    }

    // 新增商品
    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(@Valid Product product) {
        productService.saveOrUpdate(product);
        return "redirect:/Backend-product/getAllProduct";
    }

    // 導入修改商品的頁面
    @GetMapping("/getOne_For_Update/{productId}")
    public String toUpdate(@PathVariable Integer periodId, ModelMap model) {
        Optional<Product> findPeriod = productService.findById(periodId);
        model.addAttribute("Period", findPeriod.orElseThrow());
        return "backend/product/backend_pdUpdate";// 查詢完成後轉交修改團課時段的頁面
    }

    }







