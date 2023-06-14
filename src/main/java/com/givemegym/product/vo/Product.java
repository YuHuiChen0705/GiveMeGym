package com.givemegym.product.vo;

import com.givemegym.category.vo.Category;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter

@Entity
@Table(name = "product",schema = "no7")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Integer productId;
    @ManyToOne
    @JoinColumn (name = "PRODUCT_CATEGORYID")
    private Category category;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "PRODUCT_PRICE")
    private Integer productPrice;
    @Column(name = "PRODUCT_DETAIL")
    private String productDetail;
    @Column(name = "PRODUCT_STATUS")
    private Integer productStatus;
    @Column(name = "PRODUCT_CREATETIME")
    private Date productCreateTime;
    @Column(name = "PRODUCT_UPDATETIME")
    private Date productUpdateTime;


}
