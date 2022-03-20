package com.example.ljl_demo.controller;

import com.example.ljl_demo.entity.Response;
import com.example.ljl_demo.entity.User;
import com.example.ljl_demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
public class UserController {
    @Autowired
    private IUserService userService;
    //注册
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public Response register(@RequestBody Map<String,String> person){
        String username = person.get("username");
        String password = person.get("password");
        String phone = person.get("phone");

        if (username != null && password != null && phone != null){
            List<User> user = userService.queryByName(username);
            if(user.size() == 0){
                int isadd = userService.addUser(username,password,phone);
                if (isadd > 0){
                    return new Response("注册成功", 1, true);
                }else {
                    return new Response("注册失败", -1, false);
                }
            }else {
                return new Response("注册失败：用户名已存在",-1,false);
            }
        }else {
            return new Response("注册失败：用户名、密码、手机号不能为空",-1,false);
        }
    }

    //登录
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public Response login(@RequestBody Map<String, String> person) {
        String username = person.get("username");
        String password = person.get("password");

        if(username != null && password != null){
            List<User> user = userService.queryByName(username);
            if(user.size() == 0){
                return new Response("登录失败：用户名不存在", -1, false);
            }else {
                if (user.get(0).getPassword().equals(password)){
                    return new Response("登录成功", 1, true);
                }else {
                    return new Response("登录失败：密码错误", -1, false);
                }
            }
        }else {
            return new Response("登录失败：用户名密码不能为空",-1,false);
        }
    }

}