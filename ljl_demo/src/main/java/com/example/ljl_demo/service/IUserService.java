package com.example.ljl_demo.service;

import com.example.ljl_demo.entity.User;

import java.util.List;

/**
 * 根据业务关系，编写相关业务逻辑。
 */

public interface IUserService {
    int addUser(String username,String password,String phone);
    List<User>  queryByName(String username);
}