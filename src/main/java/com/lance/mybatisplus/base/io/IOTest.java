package com.lance.mybatisplus.base.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: mybatisplus  IOTest
 * @description:
 * @author: flchen
 * @create: 2021-07-12 15:39
 **/

public class IOTest {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/lance/d/test/test.txt");
        write2(file);
        System.out.println(read2(file));
        List<String> list = new LinkedList<>();
        list.add("123");
        list.add("456");
        list.forEach(System.out::println);
        Iterator it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        HashMap hashMap = new HashMap();


    }

    public static void write(File file) throws IOException {
        OutputStream os = new FileOutputStream(file, true);

        // 要写入的字符串
        String string = "松下问童子，言师采药去。只在此山中，云深不知处。";
        // 写入文件
        os.write(string.getBytes());
        // 关闭流
        os.close();
    }

    public static String read(File file) throws IOException {
        InputStream in = new FileInputStream(file);

        // 一次性取多少个字节
        byte[] bytes = new byte[1024];
        // 用来接收读取的字节数组
        StringBuilder sb = new StringBuilder();
        // 读取到的字节数组长度，为-1时表示没有数据
        int length = 0;
        // 循环取数据
        while ((length = in.read(bytes)) != -1) {
            // 将读取的内容转换成字符串
            sb.append(new String(bytes, 0, length));
        }
        // 关闭流
        in.close();

        return sb.toString();
    }


    public static void write2(File file) throws IOException {
        // OutputStreamWriter可以显示指定字符集，否则使用默认字符集
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8");

        // 要写入的字符串
        String string = "松下问童子，言师采药去。只在此山中，云深不知处。";
        osw.write(string);
        osw.close();
    }

    public static String read2(File file) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
        // 字符数组：一次读取多少个字符
        char[] chars = new char[1024];
        // 每次读取的字符数组先append到StringBuilder中
        StringBuilder sb = new StringBuilder();
        // 读取到的字符数组长度，为-1时表示没有数据
        int length;
        // 循环取数据
        while ((length = isr.read(chars)) != -1) {
            // 将读取的内容转换成字符串
            sb.append(chars, 0, length);
        }
        // 关闭流
        isr.close();
        return sb.toString();
    }


}

