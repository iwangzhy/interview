package com.wangzhy.interview.supermarket.promotion;

import java.math.BigDecimal;

/**
 * @author wangzhy
 * @date 2024年04月22日
 */
public class ThresholdPromotion {

  /**
   * 满减金额
   */
  private BigDecimal threshold;
  /**
   * 满减的折扣金额
   */
  private BigDecimal reduction;

  public ThresholdPromotion(BigDecimal threshold, BigDecimal reduction) {
    this.threshold = threshold;
    this.reduction = reduction;
  }

  /**
   * 满减
   *
   * @param total 订单金额
   * @return 满减之后的金额
   */
  public BigDecimal apply(BigDecimal total) {
    // 满足多少个满减  int num = total / threshold;
    BigDecimal num = total.divide(threshold).setScale(0, BigDecimal.ROUND_DOWN);
    // total - num * reduction
    return total.subtract(num.multiply(reduction));
  }
}
