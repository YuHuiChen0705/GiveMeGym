package com.givemegym.pdImage.vo;

import com.givemegym.product.vo.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
@Entity
@Table(name = "PRODUCT_IMAGE")
public class PdImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_IMAGE_ID")
    private Integer productImageId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "PRODUCTIMAGE_PRODUCTID")
    private Product product;

    @Column(name = "PRODUCTIMAGE")
    private byte[] productImage;
}

