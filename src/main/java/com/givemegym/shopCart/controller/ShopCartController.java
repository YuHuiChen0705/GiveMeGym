package com.givemegym.shopCart.controller;

import com.givemegym.mem.service.MemberService;
import com.givemegym.mem.vo.MemberVO;
import com.givemegym.order.service.OrderService;
import com.givemegym.order.vo.Order;
import com.givemegym.orderDetail.vo.OrderDetail;
import com.givemegym.shopCart.service.ShopCartService;
import com.givemegym.shopCart.vo.DetailDTO;
import com.givemegym.orderDetail.service.OrderDetailService;
import com.givemegym.product.service.ProductService;
import com.givemegym.product.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @Autowired
    MemberService memberService;

    @Autowired
    private EntityManager entityManager;

    @ResponseBody
    @PostMapping("/addOneToCart")
    public String addOneToCart(@RequestBody DetailDTO detailDTO, HttpSession session) {
        Integer memberId = (Integer) session.getAttribute("memberId");

        if (memberId != null) {
            Product product = productService.findById(detailDTO.getProductId()).get();
            detailDTO.setPrice(product.getProductPrice());
            detailDTO.setProductName(product.getProductName());

            // 將一筆購物項目(訂單明細DTO)和會員ID放進購物車
            return shopCartService.addOneToCart(detailDTO, memberId);
        } else {
            return "未登入";
        }
    }


    // 導入購物車頁面
    @GetMapping("/shopCart")
    public String shopCart() {
        return "frontend/order/shop_cart";
    }

    // 前端傳來要找該會員的購物車
    @ResponseBody
    @GetMapping("/shopCartByMember")
    public List<DetailDTO> findShopCart(HttpSession session) {
        Integer memberId = (Integer) session.getAttribute("memberId");
        return shopCartService.findAllItem(memberId);
    }

    @ResponseBody
    @PostMapping("/upDateCart")
    public String upDateCart(HttpSession session, @RequestBody DetailDTO detailDTO) {
        Integer memberId = (Integer) session.getAttribute("memberId");
        if (memberId != null) {
            System.out.println("開始");
            Product product = productService.findById(detailDTO.getProductId()).get();
            detailDTO.setPrice(product.getProductPrice());
            detailDTO.setProductName(product.getProductName());

            shopCartService.updateOneItem(memberId, detailDTO);
            System.out.println("結束");
        } else {
            return "沒找到Id";
        }
        return "修改成功";
    }


    @ResponseBody
    @PostMapping("/removeOneCartItem")
    public String removeOneCartItem(@RequestBody Map<String, Object> requestData, HttpSession session) {
        Integer productId = (Integer) requestData.get("productId");
        Integer memberId = (Integer) session.getAttribute("memberId");

        if (memberId != null) {

            System.out.println("開始");
            shopCartService.removeOneItem(productId, memberId);
            System.out.println("結束");

        } else {
            return "沒找到Id";
        }

        return "移除成功";
    }

    @GetMapping("/CartToCheckout")
    public String cartToCheckout() {
        return "frontend/order/shop_checkout";
    }

    @Transactional
    @PostMapping("/checkoutOrder")
    public ResponseEntity<String> checkoutOrder(@RequestBody Order order, HttpSession session) {
        Integer memberId = (Integer) session.getAttribute("memberId");
        if (memberId != null) {
            MemberVO member = memberService.findByMemberId(memberId);
            List<DetailDTO> cart = shopCartService.findAllItem(memberId);

            order.setMember(member);
            order.setStatus(1);

            Set<OrderDetail> orderDetail = order.getDetails();
            if (cart != null) {
                for (DetailDTO item : cart) {
                    OrderDetail detail = new OrderDetail();

                    Product product = entityManager.merge(productService.findById(item.getProductId()).get());
                    detail.setOrder(order);
                    detail.setProduct(product);
                    detail.setQuantity(item.getQuantity());
                    detail.setPrice(item.getPrice());

                    orderDetail.add(detail);
                }
            } else {
                return new ResponseEntity<>("訂單處理失敗", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            orderService.save(order);
            shopCartService.cleanAllCart(memberId);
            return new ResponseEntity<>("訂單處理成功", HttpStatus.OK);
        }
        return new ResponseEntity<>("訂單處理失敗", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseBody
    @GetMapping("/cleanShopCart")
    public String cleanShopCart(HttpSession session) {
        Integer memberId = (Integer) session.getAttribute("memberId");
        if (memberId != null){
            shopCartService.cleanAllCart(memberId);
        }
        return "/shopAllProduct";
    }
}
