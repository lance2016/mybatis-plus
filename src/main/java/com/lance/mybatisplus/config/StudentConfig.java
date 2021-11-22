package com.lance.mybatisplus.config;

import com.lance.mybatisplus.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: mybatisplus  StudentConfig
 * @description:
 * @author: flchen
 * @create: 2021-11-18 14:18
 **/

@Configuration
public class StudentConfig {
    @Bean
    public Student getStudent(){
        Student student = new Student();
        student.setName("testBean");
        return student;
    }


    public static void main(String[] args) {
        System.out.println("XGB".compareTo("逻辑回归"));


    }
}
