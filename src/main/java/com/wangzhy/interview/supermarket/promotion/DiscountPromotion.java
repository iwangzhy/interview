package com.wangzhy.interview.supermarket.promotion;

import java.math.BigDecimal;

/**
 * @author wangzhy
 * @date 2024年04月22日
 */
public class DiscountPromotion {

  public static final DiscountPromotion DEFAULT_DISCOUNT_PROMOTION = new DiscountPromotion(
      new BigDecimal("1"));

  /**
   * 折扣
   */
  private BigDecimal discount;

  public DiscountPromotion(BigDecimal discount) {
    this.discount = discount;
  }

  public BigDecimal getDiscount() {
    return discount;
  }
}
