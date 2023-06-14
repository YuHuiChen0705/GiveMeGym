package com.givemegym.product.dao;

import com.givemegym.product.vo.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product,Integer> {
//    List<Product> findByCategoryId(Integer categoryId);
}
