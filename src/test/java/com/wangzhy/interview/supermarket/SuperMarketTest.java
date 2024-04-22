package com.wangzhy.interview.supermarket;

import com.wangzhy.interview.supermarket.exception.GoodsNotFoundException;
import com.wangzhy.interview.supermarket.goods.GoodsDiscount;
import com.wangzhy.interview.supermarket.goods.GoodsPrice;
import com.wangzhy.interview.supermarket.goods.impl.Apple;
import com.wangzhy.interview.supermarket.goods.impl.Mango;
import com.wangzhy.interview.supermarket.goods.impl.Strawberry;
import com.wangzhy.interview.supermarket.promotion.DiscountPromotion;
import com.wangzhy.interview.supermarket.promotion.ThresholdPromotion;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

/**
 * @author wangzhy
 * @date 2024年04月22日
 */
class SuperMarketTest {

  @Test
  public void testA() throws GoodsNotFoundException {
    SuperMarket superMarket = new SuperMarket();

    GoodsPrice.addGoodsPrice("apple", new BigDecimal("8"));
    GoodsPrice.addGoodsPrice("strawberry", new BigDecimal("13"));

    Cart cart = new Cart();
    cart.addGoods(new Apple(), new BigDecimal("1"));
    cart.addGoods(new Strawberry(), new BigDecimal("1"));

    BigDecimal calc = superMarket.calc(cart);

    assert calc.compareTo(new BigDecimal("21")) == 0;
  }

  @Test
  public void testB() throws GoodsNotFoundException {
    SuperMarket superMarket = new SuperMarket();

    GoodsPrice.addGoodsPrice("apple", new BigDecimal("8"));
    GoodsPrice.addGoodsPrice("strawberry", new BigDecimal("13"));
    GoodsPrice.addGoodsPrice("mango", new BigDecimal("20"));

    Cart cart = new Cart();
    cart.addGoods(new Apple(), new BigDecimal("1"));
    cart.addGoods(new Strawberry(), new BigDecimal("1"));
    cart.addGoods(new Mango(), new BigDecimal("1"));

    BigDecimal calc = superMarket.calc(cart);

    assert calc.compareTo(new BigDecimal("41")) == 0;
  }

  /**
   * 草莓 8 折
   *
   * @throws GoodsNotFoundException
   */
  @Test
  public void testC() throws GoodsNotFoundException {
    SuperMarket superMarket = new SuperMarket();
    // 商品价格
    GoodsPrice.addGoodsPrice("apple", new BigDecimal("8"));
    GoodsPrice.addGoodsPrice("strawberry", new BigDecimal("13"));
    GoodsPrice.addGoodsPrice("mango", new BigDecimal("20"));
    // 商品折扣
    GoodsDiscount.addPromotion("strawberry", new DiscountPromotion(new BigDecimal("0.8")));

    // 购物车
    Cart cart = new Cart();
    cart.addGoods(new Apple(), new BigDecimal("1"));
    cart.addGoods(new Strawberry(), new BigDecimal("1"));
    cart.addGoods(new Mango(), new BigDecimal("1"));

    BigDecimal calc = superMarket.calc(cart);
    assert calc.compareTo(new BigDecimal("38.4")) == 0;
  }

  /**
   * 草莓 8 折、满 100 减 10
   *
   * @throws GoodsNotFoundException
   */
  @Test
  public void testD() throws GoodsNotFoundException {
    SuperMarket superMarket = new SuperMarket();
    // 商品价格
    GoodsPrice.addGoodsPrice("apple", new BigDecimal("8"));
    GoodsPrice.addGoodsPrice("strawberry", new BigDecimal("13"));
    GoodsPrice.addGoodsPrice("mango", new BigDecimal("20"));
    // 商品折扣
    GoodsDiscount.addPromotion("strawberry", new DiscountPromotion(new BigDecimal("0.8")));
    // 满减
    superMarket.setPromotion(new ThresholdPromotion(new BigDecimal("100"), new BigDecimal("10")));

    // 购物车
    Cart cart = new Cart();
    cart.addGoods(new Apple(), new BigDecimal("1")); // 8
    cart.addGoods(new Strawberry(), new BigDecimal("1")); // 13 * 0.8 == 10.4
    cart.addGoods(new Mango(), new BigDecimal("5")); // 100

    BigDecimal calc = superMarket.calc(cart);
    assert calc.compareTo(new BigDecimal("108.4")) == 0;
  }


}