package com.example.ljl_demo.dao;

import com.example.ljl_demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
interface IUserDao {
    int addUser(User user);
    List<User> queryByName(String username);
}