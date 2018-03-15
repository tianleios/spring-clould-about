package com.tianlei.dao;

import com.tianlei.domain.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {


    List<User> findAll();
    User findUserDetailByUserName(String userName);

}
