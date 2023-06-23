package com.givemegym.shopCart.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class DetailDTO {

    private Integer productId;

    private String productName;

    private Integer quantity;

    private Integer price;

    @Override
    public String toString() {
        return "DetailDTO{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

}
