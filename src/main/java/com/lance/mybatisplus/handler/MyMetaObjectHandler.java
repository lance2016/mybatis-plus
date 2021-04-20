package com.lance.mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @program: mybatisplus  MyMetaObjectHandler
 * @description:
 * @author: flchen
 * @create: 2021-04-11 22:07
 **/
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }



    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",  LocalDateTime.now(), metaObject);
    }


}
