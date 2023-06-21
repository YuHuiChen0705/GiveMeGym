package com.givemegym.product.vo;

import com.givemegym.category.vo.Category;
import com.givemegym.orderDetail.vo.OrderDetail;
import com.givemegym.pdImage.vo.PdImages;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

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
    @CreationTimestamp
    private Timestamp productCreateTime;
    @Column(name = "PRODUCT_UPDATETIME")
    @UpdateTimestamp
    private Timestamp productUpdateTime;


    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="product")
    @OrderBy("productImageId asc")
    private Set<PdImages> pdImages = new  HashSet<>();

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="product")
    private Set<OrderDetail> orderDetails = new HashSet<>();

}
