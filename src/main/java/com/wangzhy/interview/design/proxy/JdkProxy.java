package com.wangzhy.interview.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {

  private Object bean;

  public JdkProxy(Object bean) {
    this.bean = bean;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    String methodName = method.getName();
    if (methodName.equals("wakeup")) {
      System.out.println("早安~~~");
    } else if (methodName.equals("sleep")) {
      System.out.println("晚安~~~");
    }

    return method.invoke(bean, args);
  }


  public static void main(String[] args) {
    JdkProxy proxy = new JdkProxy(new Student("张三"));
    Person student = (Person) Proxy.newProxyInstance(
        proxy.getClass().getClassLoader(),
        new Class[]{Person.class},
        proxy
    );
    student.wakeup();
    student.sleep();
  }
}