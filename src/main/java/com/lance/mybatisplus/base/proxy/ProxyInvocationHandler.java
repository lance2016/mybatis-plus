package com.lance.mybatisplus.base.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: mybatisplus  Proxy
 * @description:
 * @author: flchen
 * @create: 2021-07-15 22:26
 **/

public class ProxyInvocationHandler implements InvocationHandler {
    private Object obj;

    ProxyInvocationHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行" + method.getName() + "方法");
        MonitorUtil.start();
        Object result = method.invoke(obj, args);
        MonitorUtil.finish(method.getName());
        return result;
    }

    public static void main(String[] args) {
        Person actor = new Actor();
        InvocationHandler invocationHandler = new ProxyInvocationHandler(actor);
        Person proxyActor = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, invocationHandler);

        proxyActor.saySomething();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Actress.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before");
                Object result = methodProxy.invokeSuper(o,objects);
                System.out.println("after");
                return result;
            }
        });
        Actress p2 = (Actress) enhancer.create();
        p2.saySomething();
        System.out.println(p2.hashCode());


        ReentrantLock lock = new ReentrantLock(true);
        lock.lock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
