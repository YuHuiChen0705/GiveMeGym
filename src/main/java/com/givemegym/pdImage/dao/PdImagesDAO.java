package com.givemegym.pdImage.dao;

import com.givemegym.pdImage.vo.PdImages;
import com.givemegym.product.vo.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PdImagesDAO extends JpaRepository<PdImages,Integer> {
//    List<PdImages> findByProductId(Integer productId);
}
