package com.givemegym.product.service;
import com.givemegym.product.vo.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    boolean isDup(Integer productId);

    /*新增或修改問題*/
    Product saveOrUpdate(Product productId);

    /*刪除 根據ID刪除單一問題*/
    void deleteById(Integer productId);

    /*查詢 根據ID查單一問題 Optional避免空值例外*/
    Optional<Product> findById(Integer productId);

    /*查詢所有商品*/
    List<Product> findAll();

    /*根據商品類別(三種類別)查商品*/
//    List<Product> findByCategoryId(Integer categoryId);


}
