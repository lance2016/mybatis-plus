package com.lance.mybatisplus.designpattern.factory;

/**
 * @program: mybatisplus  SimpleFactory
 * @description:
 * @author: flchen
 * @create: 2021-11-22 10:36
 **/

public class SimpleFactory {


    public static Calculate getInstance(String method) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        return (Calculate) Class.forName(method).newInstance();

    }

}
