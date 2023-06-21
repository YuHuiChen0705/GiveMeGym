package com.givemegym.orderDetail.vo;

import com.givemegym.order.vo.Order;
import com.givemegym.product.vo.Product;
import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@IdClass(OrderDetailId.class)
@Table(name = "SHOPORDER_DETAIL")
public class OrderDetail {

    @Id
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn (name = "SHOPORDER_DETAIL_SHOPORDERID")
    private Order order;

    @Id
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "SHOPORDER_DETAIL_PRODUCTID")
    private Product product;

    @Column(name = "SHOPORDER_DETAIL_QUANTITY")
    private Integer quantity;

    @Column(name = "SHOPORDER_DETAIL_PRICE")
    private Integer price;

}
