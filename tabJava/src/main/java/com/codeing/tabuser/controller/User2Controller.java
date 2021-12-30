package com.codeing.tabuser.controller;

import com.codeing.tabuser.domain.User;
import com.codeing.tabuser.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author Yorlg
 * @data 2021-12-28
 * @apiNote
 */

@Slf4j
@RequestMapping("user2")
@RestController
public class User2Controller {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("login")
    public String login(String name, String password) {
        if (ObjectUtils.isEmpty(name)) {
            return "用户名不能为空";
        }

        if (ObjectUtils.isEmpty(password)) {
            return "密码不能为空";
        }
        User record = new User();
        record.setName(name);
        User user = userMapper.selectOne(record);
        if (user == null){
            return "登录失败";
        }
        if(Objects.equals(password, user.getPassword())){
            return "登录成功";
        }
        return "登录失败密码错误";
    }

    @GetMapping("register")
    public String register(String name, String password) {

        if (ObjectUtils.isEmpty(name)) {
            return "用户名不能为空";
        }

        if (ObjectUtils.isEmpty(password)) {
            return "密码不能为空";
        }

        User record = new User();
        record.setName(name);
        User user = userMapper.selectOne(record);
        if (user != null){
            return "注册失败，用户已存在";
        }
        user = new User();
        user.setName(name);
        user.setPassword(password);
        int resultCount = userMapper.insertSelective(user);
        if (resultCount == 0) {
            return "注册失败";
        }
        return "注册成功";
    }
}
