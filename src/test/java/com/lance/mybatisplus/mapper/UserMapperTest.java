package com.lance.mybatisplus.mapper;


import com.lance.mybatisplus.entity.User;
import com.lance.mybatisplus.enums.StatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
@MapperScan("com.lance.mybatisplus.mapper")
class UserMapperTest {

    @Resource
    private UserMapper userMapper;
    @Test
    public void selectList(){
         userMapper.selectList(null).forEach(System.out::println);
    }
    @Test
    public void save(){
        User user = new User();
        user.setName("x");
        user.setAge(18);
        user.setStatus(StatusEnum.REST);
        userMapper.insert(user);
    }
    @Test
    public void updateName(){
        User user = userMapper.selectById(1);
        user.setName("update_"+user.getName());
        User user2 = userMapper.selectById(1);
        user2.setName("第二次更新");
        userMapper.updateById(user);
        userMapper.updateById(user2);
    }

    @Test
    public void logisticDelete(){
        userMapper.deleteById(1381212376769294342L);
    }
}