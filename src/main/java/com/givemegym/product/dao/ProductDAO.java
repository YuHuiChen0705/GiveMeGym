package com.givemegym.product.dao;

import com.givemegym.product.vo.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product,Integer> {
    @Query("SELECT p FROM Product p WHERE p.category.categoryId = :categoryId")
    List<Product> findByCategoryId(Integer categoryId);

    @Query("SELECT pdImage.productImage FROM Product pd JOIN pd.pdImages pdImage WHERE pd.productId = :productId ORDER BY pdImage.product.productId DESC")
    List<byte[]> findProductImagePathsByProductId(@Param("productId") Integer productId);

    @Query("SELECT p FROM Product p WHERE p.productStatus = 1")
    List<Product> findOnProducts();

}
