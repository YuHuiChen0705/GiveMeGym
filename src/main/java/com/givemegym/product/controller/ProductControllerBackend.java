package com.givemegym.product.controller;

import com.givemegym.pdImage.vo.PdImages;
import com.givemegym.product.service.ProductService;
import com.givemegym.product.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.*;

@Controller
public class ProductControllerBackend {
    @Autowired
    private ProductService productService;


    @GetMapping("/getAllProduct")
    public String getAllProduct(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "backend/product/backend_pdList";
    }

//從表單獲得請假資訊,導入資料庫
    @PostMapping("/SaveProduct")
    public String saveProduct(@Valid Product product) {
        productService.update(product);
        return "redirect:/getAllProduct";
    }
    // 新增商品
    @PostMapping("/SaveProduct")
    public String saveProduct(@Valid Product product) {
        productService.update(product);
        return "redirect:/getAllProduct";
    }

    @PostMapping("/UpdateProduct")
    public String updateProduct(@Valid Product product,
                                @RequestParam("productImage") List<MultipartFile> productImages) {
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
        productService.update(product);
        return "redirect:/getAllProduct";
    }

    // 導入修改商品的頁面
    @GetMapping("/updateProduct/{productId}")
    public String toUpdate(@PathVariable Integer productId, ModelMap model) throws IOException {
        Optional<Product> findProduct = productService.findById(productId);
        model.addAttribute("product", findProduct.orElseThrow());

        List<String> resources = getImageList(productId);
        model.addAttribute("resources", resources);

        return "backend/product/backend_pdUpdate";
    }


//    =====================前台功能=============================


    // 商城首頁/全商品瀏覽
    @GetMapping("/shopAllProduct")
    public String allProduct(Model model) {
        List<Product> productList = productService.findOnProducts();
        model.addAttribute("productList", productList);
        return "frontend/product/shop_index";
    }

    // 單一品項瀏覽
    @GetMapping("/shopSingleProduct/{productId}")
    public String singleProduct(@PathVariable Integer productId, ModelMap model) {
        Optional<Product> product = productService.findById(productId);
        model.addAttribute("product", product.orElseThrow());


        getImageList(productId);
        model.addAttribute("imagePaths", getImageList(productId));


        return "frontend/product/shop_single";
    }

    @GetMapping("/shopCategoryProduct/{categoryId}")
    public String categoryProduct(@PathVariable Integer categoryId, Model model) {
        List<Product> productList = productService.findByCategoryId(categoryId);
        model.addAttribute("productList", productList);
        return "frontend/product/shop_index";
    }


    // 取得圖片的List
    public List<String> getImageList(Integer productId) {
        // 拿到資料庫中所有該商品的圖片List
        List<byte[]> imagePaths = productService.findByProductId(productId);
        // 把List長度改成拿最後的三張  不到三張則不改長度
        int size = imagePaths.size();
        imagePaths = size > 2 ? imagePaths.subList(size - 3, size) : imagePaths;

        List<String> resources = new ArrayList<>();

        for (byte[] imagePath : imagePaths) {
            String base64Image = Base64.getEncoder().encodeToString(imagePath);
            resources.add(base64Image);
        }
        return resources;
    }

    @GetMapping("/image/{productId}")
    public ResponseEntity<Resource> getOneImage(@PathVariable Integer productId) {
        Product product = productService.findById(productId).get();
        List<PdImages> images = product.getPdImages().stream().toList();
        PdImages image = images.get(images.size() - 1);
        byte[] imageByte = image.getProductImage();
        ByteArrayResource resource = new ByteArrayResource(imageByte);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_GIF) // or another appropriate media type
                .body(resource);
    }
}







