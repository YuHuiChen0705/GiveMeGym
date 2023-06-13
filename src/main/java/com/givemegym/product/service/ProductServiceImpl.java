package com.givemegym.product.service;

import com.givemegym.category.vo.Category;
import com.givemegym.product.dao.ProductDAO;
import com.givemegym.product.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDAO productDAO;
    @Override
    public boolean isDup(Integer productId) {
        return false;
    }

    @Override
    public Product saveOrUpdate(Product product) {
      return productDAO.save(product);
    }

    @Override
    public void deleteById(Integer productId) {
        productDAO.deleteById(productId);
    }

    @Override
    public Optional<Product> findById(Integer productId) {
        return productDAO.findById(productId);
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

//    @Override
//    public List<Product> findByCategoryId(Integer categoryId) {
//        return productDAO.findByCategoryId(categoryId);
//    }
}
