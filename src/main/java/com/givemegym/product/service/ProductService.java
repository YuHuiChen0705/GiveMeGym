package com.givemegym.product.service;
import com.givemegym.pdImage.vo.PdImages;
import com.givemegym.product.vo.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    /*新增或修改問題*/
    Product save(Product product);

    /*新增或修改問題*/
    Product update(Product product,List<MultipartFile> productImages);

    /*刪除 根據ID刪除單一問題*/
    void deleteById(Integer productId);

    /*查詢 根據ID查單一問題 Optional避免空值例外*/
    Optional<Product> findById(Integer productId);

    /*查詢所有商品*/
    List<Product> findAll();

    /*根據商品編號查所有照片*/
    List<byte[]> findByProductId(Integer productId);

    List<Product> findOnProducts();

    /*根據商品類別(三種類別)查商品*/
    List<Product> findByCategoryId(Integer categoryId);

}
