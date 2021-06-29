package com.lance.mybatisplus.base;

import lombok.Data;
import lombok.ToString;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @program: mybatisplus  Person
 * @description: 序列化与反序列化
 * @author: flchen
 * @create: 2021-06-10 16:36
 **/

@Data
@ToString
public class Person implements Serializable {
    private String name;
    private int age;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person user = new Person();
        user.setName("yaomy");
        user.setAge(23);
        System.out.println(user);
        //序列化对象到文件中
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("template"));
        oos.writeObject(user);
        oos.close();
        //反序列化
        File file = new File("template");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Person newUser = (Person) ois.readObject();
        System.out.println(newUser.toString());
    }
}
