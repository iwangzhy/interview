package com.wangzhy.interview.supermarket;

import com.wangzhy.interview.supermarket.goods.Goods;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 购物车
 *
 * @author wangzhy
 * @date 2024年04月22日
 */
public class Cart {

  //商品 - 数量
  private Map<Goods, BigDecimal> items = new HashMap<>();

  public void addGoods(Goods goods, BigDecimal quantity) {
    items.put(goods, items.getOrDefault(goods, new BigDecimal("0")).add(quantity));
  }

  public Map<Goods, BigDecimal> getItems() {
    return items;
  }

}
