package com.lance.mybatisplus.base.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: java-base  Main
 * @description:
 * @author: flchen
 * @create: 2021-06-10 10:23
 **/

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String className = Main.class.getName();
        String prefix = className.substring(0,className.lastIndexOf(".")+1);
        List<String> methods = new ArrayList<String>() {{
            add("Selection");
            add("Bubble");
            add("Insert");
            add("Shell");
            add("Quick");
        }};
        for (String method : methods) {
            Class clazz = Class.forName(prefix+method);
            Ordering order = (Ordering) clazz.newInstance();
            order.print();
        }
    }
}
