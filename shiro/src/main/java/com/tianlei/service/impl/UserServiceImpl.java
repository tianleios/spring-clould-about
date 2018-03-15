package com.tianlei.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tianlei.dao.UserMapper;
import com.tianlei.domain.User;
import com.tianlei.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Long id) {
        return this.userMapper.findById(id);
    }

    @Override
    public User save(User user) {

         this.userMapper.save(user);
         //把刚刚插入的userId返回
         return user;

    }

    @Override
    public List<User> findUserPage(int start, int limit) {

        //紧跟在startPage 后面的sql会进行分页
        Page<User> page = PageHelper.startPage(start,limit);
        return this.userMapper.findAll();

    }

    @Override
    public User findUserDetailByUserName(String userName) {

        return this.userMapper.findUserDetailByUserName(userName);

    }
}
