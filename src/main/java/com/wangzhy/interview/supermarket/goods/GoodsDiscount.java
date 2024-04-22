package com.wangzhy.interview.supermarket.goods;

import static com.wangzhy.interview.supermarket.promotion.DiscountPromotion.DEFAULT_DISCOUNT_PROMOTION;

import com.wangzhy.interview.supermarket.promotion.DiscountPromotion;
import java.util.HashMap;
import java.util.Map;

/**
 * 商品折扣
 *
 * @author wangzhy
 * @date 2024年04月22日
 */
public class GoodsDiscount {

  // goods - discount
  private static Map<String, DiscountPromotion> discounts = new HashMap<>();

  /**
   * 设置商品的折扣
   *
   * @param goodsId  商品id
   * @param discount 折扣
   */
  public static void addPromotion(String goodsId, DiscountPromotion discount) {
    discounts.put(goodsId, discount);
  }

  /**
   * 根据商品 id 获取折扣
   *
   * @param goodsId 商品id
   * @return 商品折扣
   */
  public static DiscountPromotion getPromotion(String goodsId) {
    // 默认折扣为 1
    return discounts.getOrDefault(goodsId, DEFAULT_DISCOUNT_PROMOTION);
  }
}
