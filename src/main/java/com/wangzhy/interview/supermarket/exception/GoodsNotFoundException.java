package com.wangzhy.interview.supermarket.exception;

/**
 * @author wangzhy
 * @date 2024年04月22日
 */
public class GoodsNotFoundException extends Exception {

  private static final long serialVersionUID = 6099528083327766979L;

  // 默认构造方法
  public GoodsNotFoundException() {
    super("Goods not found.");
  }

  // 带有具体错误信息的构造方法
  public GoodsNotFoundException(String message) {
    super(message);
  }

  // 带有错误信息和原因的构造方法
  public GoodsNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  // 只带有原因的构造方法
  public GoodsNotFoundException(Throwable cause) {
    super(cause);
  }
}
