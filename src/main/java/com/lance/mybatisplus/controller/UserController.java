package com.lance.mybatisplus.controller;

import com.lance.mybatisplus.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: mybatisplus  UserController
 * @description:
 * @author: flchen
 * @create: 2021-06-29 10:48
 **/

@RestController
public class UserController {
    @Autowired
    private SysUserService sysUserService;

}
