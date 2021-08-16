package com.lance.mybatisplus.bytecode;

/**
 * @program: mybatisplus  T002ClassLoader
 * @description:
 * @author: flchen
 * @create: 2021-07-17 19:58
 **/

public class T002ClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        // 由BootstrapClassLoader加载  ，因为是由C++实现的模块，没有对应的class，所以返回是null
        System.out.println(String.class.getClassLoader());
        System.out.println(sun.awt.HKSCS.class.getClassLoader());
        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader());
        System.out.println(T001ByteCode.class.getClassLoader());
        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader().getClass().getClassLoader());
        System.out.println(T001ByteCode.class.getClassLoader());
        System.out.println(T001ByteCode.class.getClassLoader().getClass().getClassLoader());
        System.out.println(T001ByteCode.class.getClassLoader().getParent());


        Class clazz = T002ClassLoader.class.getClassLoader().loadClass("com.lance.mybatisplus.bytecode.T001ByteCode");
        System.out.println(clazz.getName());

    }
}
