package com.example.ljl_demo.service.impl;

import com.example.ljl_demo.entity.User;
import com.example.ljl_demo.dao.IUserDao;
import com.example.ljl_demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
class UserServiceImpl implements IUserService {

    @Autowired
    IUserDao userDao;

    @Override
    public int addUser(String username,String password,String phone) {
        User user = new User(username, password, phone);
        int isadd = userDao.addUser(user);
        return isadd;
    }

    @Override
    public List<User> queryByName(String username){
        List<User> userList = userDao.queryByName(username);
        return userList;
    }
}