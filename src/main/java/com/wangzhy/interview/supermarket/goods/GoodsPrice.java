package com.wangzhy.interview.supermarket.goods;

import com.wangzhy.interview.supermarket.exception.GoodsNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 商品价格
 *
 * @author wangzhy
 * @date 2024年04月22日
 */
public class GoodsPrice {

  // goods - price
  private static Map<String, BigDecimal> priceList = new HashMap<>();

  public static void addGoodsPrice(String goodsId, BigDecimal price) {
    priceList.put(goodsId, price);
  }

  /**
   * 根据商品 id 获取价格
   *
   * @param goodsId 商品id
   * @return 商品价格
   */
  public static BigDecimal getGoodsPrice(String goodsId) throws GoodsNotFoundException {
    if (!priceList.containsKey(goodsId)) {
      throw new GoodsNotFoundException();
    }
    return priceList.get(goodsId);
  }


}
