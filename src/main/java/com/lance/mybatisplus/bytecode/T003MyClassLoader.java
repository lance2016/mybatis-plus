package com.lance.mybatisplus.bytecode;

/**
 * @program: mybatisplus  T003MyClassLoader
 * @description:
 * @author: flchen
 * @create: 2021-07-17 20:43
 **/

public class T003MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
