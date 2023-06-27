package com.givemegym.product.service;

import com.givemegym.category.vo.Category;
import com.givemegym.product.dao.ProductDAO;
import com.givemegym.product.vo.Product;
import com.givemegym.pdImage.vo.PdImages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDAO productDAO;

    @Override
    public Product save(Product product) {
       return productDAO.save(product);
    }

    @Override
    public Product update(Product product,List<MultipartFile> productImages) {
        if (productImages != null && !productImages.isEmpty()) {
            // 建立存放商城圖片的set
            Set<PdImages> images = product.getPdImages();
            if (images == null) {
                images = new HashSet<>();
            }
            // 迭代讀取使用者上傳的圖片  處理並保存圖片
            for (MultipartFile productImage : productImages) {
                if (!productImage.isEmpty()) {
                    try {

                        // 取得圖片byte[]
                        byte[] image = productImage.getBytes();
                        // 建立新的 PdImages 物件
                        PdImages pdImage = new PdImages();
                        pdImage.setProduct(product);
                        // 存圖片的byte[]在資料庫裡
                        pdImage.setProductImage(image);
                        // 將圖片存在商品圖片集合裡
                        images.add(pdImage);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            // 修改商品(同時也新增圖片)
        }

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

    @Override
    public List<byte[]> findByProductId(Integer productId) {
        return productDAO.findProductImagePathsByProductId(productId);
    }

    @Override
    public List<Product> findOnProducts() {
        return productDAO.findOnProducts();
    }

    @Override
    public List<Product> findByCategoryId(Integer categoryId) {
        return productDAO.findByCategoryId(categoryId);
    }

}
