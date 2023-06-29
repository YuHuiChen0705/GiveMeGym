package com.givemegym.order.controller;

import com.givemegym.order.service.OrderService;
import com.givemegym.shopCart.vo.DetailDTO;
import com.givemegym.order.vo.Order;
import com.givemegym.orderDetail.service.OrderDetailService;
import com.givemegym.orderDetail.vo.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/getAllOrder")
    public String getAllOrder(Model model){
        List<Order> orderList = orderService.findAll();
        model.addAttribute("orderList",orderList);
        return "/backend/order/backend_orderList";
    }

    @GetMapping("/updateOrder/{orderId}")
    public String toUpdate(@PathVariable Integer orderId, ModelMap model) throws IOException {
        Optional<Order> order = orderService.findById(orderId);
        model.addAttribute("order", order.orElseThrow());

        List<OrderDetail> details = orderDetailService.findByOrderId(orderId);
        model.addAttribute("details",details);

        return "backend/order/backend_orderDetail";
    }

    @PostMapping("/UpdateOrderStatus/{orderId}")
    public String updateStatus(@PathVariable Integer orderId,@RequestParam("status") Integer orderStatus){
        Order order = orderService.findById(orderId).get();
        order.setStatus(orderStatus);
        orderService.update(order);
        return "redirect:/getAllOrder";
    }

// ======================================================================

    @GetMapping("/memberOrderList")
    public String orderListAll(ModelMap model, HttpSession session){
        Integer memberId = (Integer)session.getAttribute("memberId");
        List<Order> orders = orderService.findByMemberId(memberId);
        model.addAttribute("orders",orders);
        return "frontend/order/shop_order_detail";
    }

    @ResponseBody
    @GetMapping("/orders/{orderId}/details")
    public List<DetailDTO> getOrderDetails(@PathVariable Integer orderId) {

        List<OrderDetail> orderDetails = orderDetailService.findByOrderId(orderId);
        List<DetailDTO> detailDTOList = new ArrayList<>();

        for (OrderDetail orderDetail:orderDetails) {
            DetailDTO dto = new DetailDTO();
            dto.setProductId(orderDetail.getProduct().getProductId());
            dto.setProductName(orderDetail.getProduct().getProductName());
            dto.setQuantity(orderDetail.getQuantity());
            dto.setPrice(orderDetail.getPrice());

            detailDTOList.add(dto);
        }

        return detailDTOList;
    }

    @ResponseBody
    @GetMapping("/orders/{orderId}")
    public Map<String,String> getOneOrder(@PathVariable Integer orderId) {
        Map<String,String> orderMap = new HashMap<>();
        Order order = orderService.findById(orderId).get();

        orderMap.put("note",order.getNote());
        orderMap.put("address",order.getAddress());
        orderMap.put("phone",order.getPhone().toString());
        orderMap.put("name",order.getName());
        return orderMap;
    }


}
