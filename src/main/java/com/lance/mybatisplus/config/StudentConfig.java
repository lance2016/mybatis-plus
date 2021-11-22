package com.lance.mybatisplus.config;

import com.lance.mybatisplus.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  通过方法返回第三方jar包的对象，然后项目中就可以使用autowired导入
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
