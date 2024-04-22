package com.wangzhy.interview.supermarket.goods;

import com.wangzhy.interview.supermarket.exception.GoodsNotFoundException;
import com.wangzhy.interview.supermarket.promotion.DiscountPromotion;
import java.math.BigDecimal;

/**
 * 商品
 *
 * @author wangzhy
 * @date 2024年04月22日
 */
public interface Goods {

  String getGoodsId();

  /**
   * 获得商品的单价
   *
   * @return
   */
  default BigDecimal getPrice() throws GoodsNotFoundException {
    return GoodsPrice.getGoodsPrice(getGoodsId());
  }

  /**
   * 折扣
   *
   * @return
   */
  default DiscountPromotion getDiscountPromotion() {
    return GoodsDiscount.getPromotion(getGoodsId());
  }

  /**
   * 计算金额
   *
   * @param quantity 商品的数量
   * @return
   */
  default BigDecimal calcBill(BigDecimal quantity) throws GoodsNotFoundException {
    // price * quantity * discount
    return getPrice().multiply(quantity).multiply(getDiscountPromotion().getDiscount());
  }

}
