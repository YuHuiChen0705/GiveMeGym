package com.givemegym.shopCart.service;

import com.givemegym.shopCart.vo.DetailDTO;

import java.util.List;

public interface ShopCartService {
    public String addOneToCart(DetailDTO detailDTO,Integer memberId);

    public List<DetailDTO> findAllItem(Integer memberId);
}
