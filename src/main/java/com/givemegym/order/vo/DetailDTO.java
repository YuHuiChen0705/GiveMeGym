package com.givemegym.order.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class DetailDTO {
    private Integer orderId;

    private Integer productId;

    private String productName;

    private Integer quantity;

    private Integer price;

}
