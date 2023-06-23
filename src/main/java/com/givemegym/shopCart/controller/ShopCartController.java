package com.givemegym.shopCart.controller;

import com.givemegym.mem.vo.MemberVO;
import com.givemegym.order.service.OrderService;
import com.givemegym.shopCart.service.ShopCartService;
import com.givemegym.shopCart.vo.DetailDTO;
import com.givemegym.orderDetail.service.OrderDetailService;
import com.givemegym.product.service.ProductService;
import com.givemegym.product.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ShopCartController {
    @Autowired
    OrderService orderService;

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    ProductService productService;

    @Autowired
    ShopCartService shopCartService;


    @ResponseBody
    @PostMapping("/addOneToCart")
    public String addOneToCart(@RequestBody DetailDTO detailDTO, HttpServletRequest request) {
//      MemberVO member =(MemberVO) request.getSession().getAttribute("member");
//      if(member!=null){
//          Integer memberId = member.getMemberId();
//      }else{
//          return "redirect:/login";
//      }

//      暫時還沒有  先以寫死的代替
        Integer memberId = 3;

        Product product = productService.findById(detailDTO.getProductId()).get();
        detailDTO.setPrice(product.getProductPrice());
        detailDTO.setProductName(product.getProductName());

        // 將一筆購物項目(訂單明細DTO)和會員ID放進購物車
        return shopCartService.addOneToCart(detailDTO, memberId);

    }


    // 導入購物車頁面
    @GetMapping("/shopCart")
    public String shopCart(){
        return "frontend/order/shop_cart";
    }

    // 前端傳來要找該會員的購物車
    @ResponseBody
    @GetMapping("/shopCart/{memberId}")
    public List<DetailDTO> findShopCart(@PathVariable Integer memberId){
        return shopCartService.findAllItem(memberId);
    }

}
