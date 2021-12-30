package com.codeing.tabuser.controller;

import com.codeing.tabuser.book.JsonResult;
import com.codeing.tabuser.domain.User;
import com.codeing.tabuser.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * @author Yorlg
 * @data 2021-12-28
 * @apiNote
 */

@Slf4j
@RequestMapping("user")
@RestController
@Configuration
public class UserController {

    @Autowired
    private UserMapper userMapper;


    /**
     * 登录
     * @param name
     * @param password
     * @return
     */
    @GetMapping("login")
    public String login(String name, String password) {
        User user = userMapper.selectUser(name);
        if (user == null) {
            return "登录失败";
        }
        if (user.getName().equals(name) && user.getPassword().equals(password)) {
            return "登录成功";
        }
        return "登录失败密码错误";
    }

    /**
     * 注册
     * @param name
     * @param password
     * @return
     */
    @GetMapping("register")
    public String register(String name, String password) {

        if (ObjectUtils.isEmpty(name)) {
            return "用户名不能为空";
        }

        if (ObjectUtils.isEmpty(password)) {
            return "密码不能为空";
        }

        User user = userMapper.selectUser(name);
        if (user != null) {
            return "注册失败，用户已存在";
        }
        int resultCount = userMapper.savaUser(name, password);
        if (resultCount == 0) {
            return "注册失败";
        }
        return "注册成功";
    }

    /**
     * 查询全部
     * @return
     */
    @RequestMapping("alluser")
    public JsonResult alluser() {
        JsonResult result = new JsonResult();
        result.code = 200;
        result.msg = "";
        result.data = userMapper.allUser();
        return result;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("deluser")
    public JsonResult deluser(int id) {
        JsonResult result = new JsonResult();
        if (ObjectUtils.isEmpty(id)) {
            result.code = 201;
            result.msg = "删除失败";
        } else {
            result.code = 200;
            result.msg = "删除成功";
            result.data = (List) userMapper.delUser(id);
        }

        return result;
    }

    /**
     * 修改
     * @param name
     * @param password
     * @param id
     * @return
     */
    @GetMapping("edituser")
    public JsonResult edituser(String name, String password, int id) {
        JsonResult result = new JsonResult();
        if (ObjectUtils.isEmpty(id)) {
            result.code = 201;
            result.msg = "修改失败";
        } else {
            result.code = 200;
            result.msg = "修改成功";
            result.data = (List) userMapper.editUser(name, password, id);
        }

        return result;
    }
}
