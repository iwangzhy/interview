package com.wangzhy.interview.supermarket;

import com.wangzhy.interview.supermarket.exception.GoodsNotFoundException;
import com.wangzhy.interview.supermarket.goods.Goods;
import com.wangzhy.interview.supermarket.promotion.ThresholdPromotion;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author wangzhy
 * @date 2024年04月22日
 */
public class SuperMarket {

  private ThresholdPromotion promotion;

  public void setPromotion(ThresholdPromotion promotion) {
    this.promotion = promotion;
  }

  /**
   * 总金额
   *
   * @param cart
   * @return
   */
  public BigDecimal calc(Cart cart) throws GoodsNotFoundException {
    Map<Goods, BigDecimal> items = cart.getItems();
    Iterator<Entry<Goods, BigDecimal>> iterator = items.entrySet().iterator();
    BigDecimal total = new BigDecimal("0");
    while (iterator.hasNext()) {
      Entry<Goods, BigDecimal> next = iterator.next();
      total = total.add(next.getKey().calcBill(next.getValue()));
    }

    // 满减折扣
    return promotion == null ? total : promotion.apply(total);
  }
}
