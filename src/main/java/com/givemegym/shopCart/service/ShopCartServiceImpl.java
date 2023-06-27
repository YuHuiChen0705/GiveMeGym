package com.givemegym.shopCart.service;

import com.givemegym.shopCart.vo.DetailDTO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopCartServiceImpl implements ShopCartService {

    @Override
    public String addOneToCart(DetailDTO cartItem, Integer memberId) {
        // 拿到前端的購物項 先轉成JSON物件
        Gson gson = new Gson();
        String dtoString = gson.toJson(cartItem);
        JsonObject newItem = gson.fromJson(dtoString, JsonObject.class);

        Jedis jedis = null;
        try {
            // 取得Jedis連線
            jedis = new Jedis("localhost", 6379);

            // 一個會員只有一台購物車，先看購物車存不存在
            String cartStr = jedis.get("memberId:" + memberId);

            JsonArray cart = null;

            if (cartStr == null) {
                // 如果購物車不存在 就設一個JSONArray
                cart = new JsonArray();
                // 把購物項加入(全新購物車)
                cart.add(newItem);
                // 購物車包成一個字串
                cartStr = cart.toString();

                // 放入redis資料庫
                jedis.set("memberId:" + memberId, cartStr);
            } else {
                // 如果購物車已存在
                //  String cartStr變成JSONArray
                cart = gson.fromJson(cartStr, JsonArray.class);

                // 檢查商品是不是已經在購物車
                boolean itemExists = false;
                for (JsonElement element : cart) {
                    // 取出購物車原有的購物項
                    JsonObject oldItem = element.getAsJsonObject();

                    // 如果productId一樣  商品數量+1
                    if (oldItem.get("productId").getAsInt() == newItem.get("productId").getAsInt()) {
                        int quantity = oldItem.get("quantity").getAsInt();
                        int newQuantity = newItem.get("quantity").getAsInt();
                        int totalQuantity = quantity + newQuantity >= 5 ? 5 : quantity + newQuantity;
                        oldItem.addProperty("quantity", totalQuantity);
                        itemExists = true; // 標記商品已存在購物車中
                        break;
                    }

                }

                // 如果商品不在，加進購物車
                if (!itemExists) {
                    cart.add(newItem);
                }

                // 更新購物車字串
                cartStr = cart.toString();

                // 存入Redis
                jedis.set("memberId:" + memberId, cartStr);

            }
            //確認購物車裡到底有甚麼鬼
            System.out.println(cartStr);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

        return "成功加入Redis";

    }

    @Override
    public List<DetailDTO> findAllItem(Integer memberId) {
        List<DetailDTO> response = new ArrayList<>();
        Jedis jedis = null;
        Gson gson = new Gson();

        try {
            // 取得Jedis連線
            jedis = new Jedis("localhost", 6379);

            // 一個會員只有一台購物車，先取得購物車
            String cartStr = jedis.get("memberId:" + memberId);
            // 如果購物車存在
            if (cartStr != null) {
                JsonArray cart = gson.fromJson(cartStr, JsonArray.class);
                // 迭代取出每個JsonObject
                for (JsonElement element : cart) {
                    JsonObject oldItem = element.getAsJsonObject();
                    // 迴圈每次都建立一個新物件
                    DetailDTO dto = new DetailDTO();
                    dto.setProductId(oldItem.get("productId").getAsInt());
                    dto.setProductName(oldItem.get("productName").getAsString());
                    dto.setQuantity(oldItem.get("quantity").getAsInt());
                    dto.setPrice(oldItem.get("price").getAsInt());
                    // 加進要回應的List裡
                    response.add(dto);
                }
            }

        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        if (response.isEmpty()) {
            return null;
        }

        return response;
    }

    @Override
    public void updateOneItem(Integer memberId, DetailDTO cartItem) {
        // 拿到前端的購物項 先轉成JSON物件
        Gson gson = new Gson();
        String dtoString = gson.toJson(cartItem);
        JsonObject newItem = gson.fromJson(dtoString, JsonObject.class);

        Jedis jedis = null;
        try {
            // 取得Jedis連線
            jedis = new Jedis("localhost", 6379);

            // 一個會員只有一台購物車，先看購物車存不存在
            String cartStr = jedis.get("memberId:" + memberId);

            JsonArray cart = null;

            if (cartStr == null) {
                // 如果購物車不存在 就設一個JSONArray
                cart = new JsonArray();
                // 把購物項加入(全新購物車)
                cart.add(newItem);
                // 購物車包成一個字串
                cartStr = cart.toString();

                // 放入redis資料庫
                jedis.set("memberId:" + memberId, cartStr);
            } else {
                // 如果購物車已存在
                //  String cartStr變成JSONArray
                cart = gson.fromJson(cartStr, JsonArray.class);

                // 檢查商品是不是已經在購物車
                boolean itemExists = false;
                for (JsonElement element : cart) {
                    // 取出購物車原有的購物項
                    JsonObject oldItem = element.getAsJsonObject();

                    // 如果productId一樣  商品數量+1
                    if (oldItem.get("productId").getAsInt() == newItem.get("productId").getAsInt()) {
                        int newQuantity = newItem.get("quantity").getAsInt();
                        // !!!!! 重要 !!!!!!  修改數量為新的數量
                        oldItem.addProperty("quantity", newQuantity);
                        itemExists = true; // 標記商品已存在購物車中
                        break;
                    }
                }

                // 如果商品不在，加進購物車
                if (!itemExists) {
                    cart.add(newItem);
                }

                // 更新購物車字串
                cartStr = cart.toString();

                // 存入Redis
                jedis.set("memberId:" + memberId, cartStr);

            }
            //確認購物車裡到底有甚麼鬼
            System.out.println(cartStr);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

    }

    @Override
    public void removeOneItem(Integer productId,Integer memberId) {
        // 拿到前端的購物項 先轉成JSON物件
        Gson gson = new Gson();

        Jedis jedis = null;
        try {
            // 取得Jedis連線
            jedis = new Jedis("localhost", 6379);

            // 一個會員只有一台購物車，先看購物車存不存在
            String cartStr = jedis.get("memberId:" + memberId);


            if (cartStr != null) {
                // 如果購物車存在
                //  String cartStr變成JSONArray
                JsonArray cart = gson.fromJson(cartStr, JsonArray.class);

                // 檢查商品是不是已經在購物車
                for (JsonElement element : cart) {
                    // 取出購物車原有的購物項
                    JsonObject oldItem = element.getAsJsonObject();

                    // 如果productId一樣  移除該商品
                    if (oldItem.get("productId").getAsInt() == productId) {
                        cart.remove(oldItem);
                        break;
                    }
                }
                // 更新購物車字串
                cartStr = cart.toString();

                // 存入Redis
                jedis.set("memberId:" + memberId, cartStr);

            }
            //確認購物車裡到底有甚麼鬼
            System.out.println(cartStr);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public void cleanAllCart(Integer memberId) {
        // 找出會員的購物車，把JsonArray裡的物件清空
    }
}
