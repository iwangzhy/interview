package com.wangzhy.interview.design.proxy;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

  private Enhancer enhancer = new Enhancer();

  private Object bean;

  public CglibProxy(Object bean) {
    this.bean = bean;
  }

  public Object getProxy() {
    //设置需要创建子类的类
    enhancer.setSuperclass(bean.getClass());
    enhancer.setCallback(this);
    //通过字节码技术动态创建子类实例
    return enhancer.create();
  }

  //实现MethodInterceptor接口方法
  public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
      throws Throwable {
    String methodName = method.getName();
    if (methodName.equals("wakeup")) {
      System.out.println("早安~~~");
    } else if (methodName.equals("sleep")) {
      System.out.println("晚安~~~");
    }

    //调用原bean的方法
    return method.invoke(bean, args);
  }

  public static void main(String[] args) {
    CglibProxy proxy = new CglibProxy(new Student("张三"));
    Student student = (Student) proxy.getProxy();
    student.wakeup();
    student.sleep();
  }
}