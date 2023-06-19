package com.givemegym.product.controller;

import com.givemegym.pdImage.vo.PdImages;
import com.givemegym.product.service.ProductService;
import com.givemegym.product.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
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
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    // 導入新增商品時段的頁面
    @GetMapping("/addProduct")
    public String addProduct() {
        return "backend/product/backend_pdInsert";
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
            int imageCount = 1;
            // 迭代讀取使用者上傳的圖片  處理並保存圖片
            for (MultipartFile productImage : productImages) {
                if (!productImage.isEmpty()) {
                    try {
                        // 獲取圖片的原始檔案名稱
                        String originalFileName = productImage.getOriginalFilename();

                        // 生成一個新的檔案名稱，以避免檔案名稱衝突
                        String newFileName = product.getProductId() + "_" + imageCount + "_" + originalFileName;

                        // 指定伺服器上保存圖片的目標路徑
                        //  String targetDirectory = ResourceUtils.getFile("classpath:" + "static/shop_19/images/").getAbsolutePath();;
                        String targetDirectory = new File("src/main/resources/static/shop_19/images").getAbsolutePath();
                        ;
                        System.out.println("存在本機的 : " + targetDirectory);

                        // 組合出完整的檔案路徑
                        String filePath = targetDirectory + "\\" + newFileName;
                        System.out.println("完整含檔名的路徑 : " + filePath);

                        // 將圖片檔案保存至指定路徑
                        try (OutputStream outputStream = new FileOutputStream(filePath)) {
                            outputStream.write(productImage.getBytes());
                        }

                        System.out.println("存在資料庫的 : " + "/shop_19/images/" + newFileName);
                        // 建立新的 PdImages 物件
                        PdImages pdImage = new PdImages();
                        pdImage.setProduct(product);
                        // 存圖片在伺服器的路徑
                        pdImage.setProductImage("/shop_19/images/" + newFileName);

                        // 將圖片存在商品圖片集合裡
                        images.add(pdImage);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                imageCount++;
            }
            // 修改商品(同時也新增圖片)
        }
        productService.update(product);
        return "redirect:/getAllProduct";
    }

    // 導入修改商品的頁面
    @GetMapping("/updateProduct/{productId}")
    public String toUpdate(@PathVariable Integer productId, ModelMap model) {
        Optional<Product> findProduct = productService.findById(productId);
        model.addAttribute("product", findProduct.orElseThrow());

        // 拿到資料庫中所有該商品的圖片List
        List<String> imagePaths = productService.findByProductId(productId); // 假設有一個名為 getProductImages 的方法

        // 把List長度改成拿最後的三張  不到三張則不改長度
        int size = imagePaths.size();
        imagePaths = size > 2 ? imagePaths.subList(size - 3, size) : imagePaths;

        model.addAttribute("imagePaths", imagePaths);
        return "backend/product/backend_pdUpdate";
    }

//    單一類別找多個商品
//    @GetMapping("/getCategoryProduct")
//    @ModelAttribute()
//    public List<Product> findCategoryProduct(Model model){
//        List<Product> categoryProductList = CategoryService.findByPrimaryKey();
//        return categoryProductList;
//    }

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
    public String singleProduct(@PathVariable Integer productId, ModelMap model){
        Optional<Product> product = productService.findById(productId);
        model.addAttribute("product", product.orElseThrow());

        List<String> imagePaths = productService.findByProductId(productId);
        int size = imagePaths.size();
        imagePaths = size > 2 ? imagePaths.subList(size - 3, size) : imagePaths;
        model.addAttribute("imagePaths", imagePaths);

        return "frontend/product/shop_single";
    }

    @GetMapping("/shopCategoryProduct/{categoryId}")
    public String categoryProduct(@PathVariable Integer categoryId,Model model){
        List<Product> productList = productService.findByCategoryId(categoryId);
        model.addAttribute("productList", productList);
        return "frontend/product/shop_index";
    }
}







