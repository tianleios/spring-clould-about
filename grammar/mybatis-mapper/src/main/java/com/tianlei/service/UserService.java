package com.tianlei.service;

import com.tianlei.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private UserMapper userMapper;


    public void test() {

//        User queryUser = User.builder()
//                             .id(1L)
//                             .build();
//        this.userMapper.select(queryUser);
//
//        // sql拼接
//        // 操作语句
//        Example example = new Example(User.class);
//
//        this.userMapper.selectByExample(example);

        // 操作查询条件
//        Example.Criteria criteria = example.createCriteria();


    }

}
